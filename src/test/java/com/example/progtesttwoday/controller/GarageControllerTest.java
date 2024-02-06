package com.example.progtesttwoday.controller;

import com.example.progtesttwoday.entity.Garage;
import com.example.progtesttwoday.repository.ParkedShipRepository;
import com.example.progtesttwoday.service.GarageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GarageController.class)
@AutoConfigureMockMvc
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class GarageControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    GarageService garageService;

    @Test
    public void parkShip_thenStatus200() throws Exception {
        String licensePlate = "ABC123";
        mvc.perform(post("/garage/in")
                        .param("licensePlate", licensePlate))
                .andExpect(status().isOk());
    }

    @Test
    public void onCorrectParkingLotNumber_shipLeave_thenStatus200() throws Exception {
        int parkingLotNumber = 1;
        mvc.perform(put("/garage/out")
                        .param("parkingLotNumber", String.valueOf(parkingLotNumber)))
                .andExpect(status().isOk());
    }
}

