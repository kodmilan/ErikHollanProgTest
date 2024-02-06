package com.example.progtesttwoday.responseObject;

import com.example.progtesttwoday.entity.ParkedShip;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OutResponseDto {

    private ParkedShip parkedShip;
    private double cost;

    public OutResponseDto(ParkedShip parkedShip, double price) {
        this.parkedShip = parkedShip;
        this.cost = price;
    }
}
