package com.candoit.test.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WeatherDataDTO {

    private Long id;
    private String response_id;
    private String name;
    private String province;
    private double lat;
    private double lon;
    private WeatherDataInfoDTO weatherDataInfo;
    private LocalDateTime lastUpdated;
}
