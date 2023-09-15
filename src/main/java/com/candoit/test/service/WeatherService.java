package com.candoit.test.service;

import com.candoit.test.entities.WeatherData;
import com.candoit.test.repository.WeatherDataInfoRepository;
import com.candoit.test.repository.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WeatherService {

    private static final String WEATHER_API_URL = "https://ws.smn.gob.ar/map_items/weather";

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @Autowired
    private WeatherDataInfoRepository weatherDataInfoRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(fixedRate = 15000)
    public void updateWeatherData() {
        WeatherData[] weatherDataArray = restTemplate.getForObject(WEATHER_API_URL, WeatherData[].class);
        if (weatherDataArray != null) {
            LocalDateTime currentDateTime = LocalDateTime.now();
            for (WeatherData weatherData : weatherDataArray) {
                weatherData.setLastUpdated(currentDateTime);
                weatherDataRepository.save(weatherData);
            }
        }
    }


    public List<WeatherData> getLatestTemperatures() {
        return weatherDataRepository.findLatestWeatherData();
    }

}
