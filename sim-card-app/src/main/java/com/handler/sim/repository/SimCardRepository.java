package com.handler.sim.repository;

import com.handler.sim.domain.SimCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimCardRepository extends JpaRepository<SimCard, String>{
    
}
