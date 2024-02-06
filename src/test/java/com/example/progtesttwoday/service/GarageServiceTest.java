package com.example.progtesttwoday.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.example.progtesttwoday.entity.Garage;
import com.example.progtesttwoday.entity.ParkedShip;
import com.example.progtesttwoday.repository.ParkedShipRepository;

class GarageServiceTest {

    @Mock
    private Garage garage;

    @Mock
    private ParkedShipRepository parkedShipRepository;

    @InjectMocks
    private GarageService garageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testParkShip_NoAvailableSpots() {
        when(garage.getParkingLots()).thenReturn(new ParkedShip[45]);

        ResponseEntity responseEntity = garageService.park("ABC123");

        assertEquals(ResponseEntity.badRequest().body("No available spots"), responseEntity);
    }

    @Test
    void testParkShip_SuccessfulParking() {

        ParkedShip[] parkingLots = new ParkedShip[45];
        when(garage.getParkingLots()).thenReturn(parkingLots);
        when(parkedShipRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        ResponseEntity responseEntity = garageService.park("ABC123");


        assertEquals(ResponseEntity.ok().body("SHIP PARKED ON SPOT: 1"), responseEntity);
    }

}
