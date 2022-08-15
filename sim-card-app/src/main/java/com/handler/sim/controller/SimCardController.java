package com.handler.sim.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import com.handler.sim.domain.dto.SimCardDTO;

import com.handler.sim.service.SimCardService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimCardController {

    @Autowired
    private SimCardService simCardService;

    @GetMapping("/")
    public ResponseEntity<String> isServerUp(){
        return ResponseEntity.ok("The Server is Up and Running!");
    }

    @PostMapping("/add")
    public ResponseEntity<SimCardDTO> addNewSimCard(SimCardDTO newSim) {
        return ResponseEntity.ok().body(simCardService.addNewSimCard(newSim));
    }

    @GetMapping("/listall")
    public ResponseEntity<List<SimCardDTO>> getAllSimCards() {
        return ResponseEntity.ok().body(simCardService.getAllSimCards());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimCardDTO> updateSimCardDetails(@PathParam("id") String id, @RequestBody SimCardDTO updatedSimDetails) {
        return ResponseEntity.ok().body(simCardService.updateSimCardDetails(id, updatedSimDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSimCardDetails(@PathParam("id") String id) {
        return ResponseEntity.ok().body(simCardService.deleteSimCardDetails(id));
    }

    @GetMapping("/to-renew")
    public ResponseEntity<List<SimCardDTO>> getAllSimCardsToRenew() {
        return ResponseEntity.ok().body(simCardService.aboutToExpireIn30Days());
    }

    @PutMapping("/renew/{id}")
    public ResponseEntity<SimCardDTO> renewSim(@PathParam("id") String id, @RequestParam("expiryDate") LocalDate expiryDate) {
        return ResponseEntity.ok().body(simCardService.renewSim(id, expiryDate));
    }

}
