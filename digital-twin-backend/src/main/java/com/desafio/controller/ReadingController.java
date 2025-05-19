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

    @GetMapping("/{sensorId}")
    public List<Reading> getBySensorId(@PathVariable String sensorId) {
        return repository.findBySensorId(sensorId);
    }
}