package com.candoit.test.repository;

import com.candoit.test.entities.WeatherDataInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataInfoRepository extends JpaRepository<WeatherDataInfo, Long> {
}
