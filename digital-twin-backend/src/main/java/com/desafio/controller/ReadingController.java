package com.desafio.controller;

import com.desafio.model.Reading;
import com.desafio.repository.ReadingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
@CrossOrigin(origins = "*") // Libera CORS
public class ReadingController {

    private final ReadingRepository repository;

    public ReadingController(ReadingRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Reading createReading(@RequestBody Reading reading) {
        return repository.save(reading);
    }

    @GetMapping
    public List<Reading> getAllReadings() {
        return repository.findAll();
    }

    @GetMapping("/{sensorName}")
    public List<Reading> getBySensorName(@PathVariable String sensorName) {
        return repository.findBySensorName(sensorName);
    }
}