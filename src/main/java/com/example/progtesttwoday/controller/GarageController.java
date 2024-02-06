package com.example.progtesttwoday.controller;

import com.example.progtesttwoday.service.GarageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/garage")
public class GarageController {

    private final GarageService garageService;

    @PostMapping("/in")
    public ResponseEntity park(@RequestParam String licensePlate) {
        return garageService.park(licensePlate);
    }

    @PutMapping("/out")
    public ResponseEntity leave(@RequestParam int parkingLotNumber) {
        return garageService.leave(parkingLotNumber);
    }

    @GetMapping("/parkedShips")
    public ResponseEntity parkedShips() {
        return garageService.parkedShips();
    }

}
