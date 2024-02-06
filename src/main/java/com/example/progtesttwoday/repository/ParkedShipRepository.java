package com.example.progtesttwoday.repository;

import com.example.progtesttwoday.entity.ParkedShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkedShipRepository extends JpaRepository<ParkedShip, Long> {
    List<ParkedShip> findByLeavingDateTimeIsNull();
}
