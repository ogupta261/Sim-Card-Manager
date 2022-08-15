package com.handler.sim.repository;

import com.handler.sim.domain.SimCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimCardRepository extends JpaRepository<SimCard, String>{

    @Query(value = "SELECT * FROM SIM_CARD WHERE DATEDIFF(dd, EXPIRY_DATE, CURRENT_TIMESTAMP)<31", nativeQuery = true)
    public List<SimCard> getAllSimCardsExpiringIn30Days();

}
