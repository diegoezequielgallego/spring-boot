package com.candoit.test.dto;

import lombok.Data;

@Data
public class WeatherDataInfoDTO {

    private Long id;
    private int humidity;
    private double pressure;
    private String description;
    private double temp;
    private String wind_deg;
    private String tempDesc;
}
