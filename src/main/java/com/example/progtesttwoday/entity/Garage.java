package com.example.progtesttwoday.entity;

import org.springframework.stereotype.Component;

@Component
public class Garage {

    private ParkedShip[] parkedShips;

    public Garage() {
        this.parkedShips = new ParkedShip[45];
    }

    public ParkedShip[] getParkingLots() {
        return parkedShips;
    }
}
