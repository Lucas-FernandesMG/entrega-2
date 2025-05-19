package com.desafio.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorId;
    private Double value;
    private LocalDateTime timestamp;

    public Reading() {}

    public Reading(String sensorId, Double value, LocalDateTime timestamp) {
        this.sensorId = sensorId;
        this.value = value;
        this.timestamp = timestamp;
    }

    // Getters e Setters
}