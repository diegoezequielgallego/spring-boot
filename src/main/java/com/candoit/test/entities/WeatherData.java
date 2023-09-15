package com.candoit.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("_id")
    private String response_id;
    private String name;
    private String province;
    private double lat;
    private double lon;
    @JsonProperty("weather")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "weather_data_info_id" )
    private WeatherDataInfo weatherDataInfo;
    private LocalDateTime lastUpdated;

}
