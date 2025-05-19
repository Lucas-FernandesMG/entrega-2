package com.desafio.repository;

import com.desafio.model.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReadingRepository extends JpaRepository<Reading, Long> {
    List<Reading> findBySensorId(String sensorId);
}