package com.candoit.test.controller;


import com.candoit.test.dto.WeatherDataDTO;
import com.candoit.test.service.WeatherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/weather")
@Secured({ "ROLE_ADMIN", "ROLE_USER" })
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/temperatures")
    public List<WeatherDataDTO> getLatestTemperatures() {
        return weatherService.getLatestTemperatures().stream()
                .map(weatherData -> modelMapper.map(weatherData, WeatherDataDTO.class))
                .collect(Collectors.toList());
    }

}
