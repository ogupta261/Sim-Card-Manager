package com.handler.sim.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import com.handler.sim.domain.dto.SimCardDTO;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimCardController {
    
    @GetMapping("/")
    public ResponseEntity<String> isServerUp(){
        return ResponseEntity.ok("The Server is Up and Running!");
    }

    @PostMapping("/add")
    public ResponseEntity<SimCardDTO> addNewSimCard(SimCardDTO newSim) {
        return ResponseEntity.ok().body(new SimCardDTO());
    }

    @GetMapping("/listall")
    public ResponseEntity<List<SimCardDTO>> getAllSimCards() {
        return ResponseEntity.ok().body(new ArrayList<>());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimCardDTO> updateSimCardDetails(@PathParam("id") String id) {
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSimCardDetails(@PathParam("id") String id) {
        return ResponseEntity.ok("Deleted!");
    }

}
