package com.candoit.test.repository;

import com.candoit.test.entities.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

    @Query("SELECT wd FROM WeatherData wd WHERE wd.lastUpdated = (SELECT MAX(wd2.lastUpdated) FROM WeatherData wd2)")
    List<WeatherData> findLatestWeatherData();
}
