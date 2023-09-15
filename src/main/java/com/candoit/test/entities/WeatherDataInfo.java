package com.candoit.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDataInfo {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int humidity;
    private double pressure;
    private String description;
    private double temp;
    private String wind_deg;
    private String tempDesc;

}
