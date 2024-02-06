package com.example.progtesttwoday.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class ParkedShip {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private String licensePlate;

    private LocalDateTime parkingDateTime;

    private LocalDateTime leavingDateTime;

    private int parkingLot;

    private double finalParkingCost;

    public ParkedShip(String licensePlate) {
        this.licensePlate = licensePlate;
        this.parkingDateTime = LocalDateTime.now();
    }
}
