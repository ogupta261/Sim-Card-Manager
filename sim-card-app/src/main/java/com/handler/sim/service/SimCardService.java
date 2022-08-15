package com.handler.sim.service;

import com.handler.sim.domain.SimCard;
import com.handler.sim.domain.dto.SimCardDTO;
import com.handler.sim.repository.SimCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.handler.sim.mapper.SimCardMapper.*;

@Service
public class SimCardService {

    @Autowired
    private SimCardRepository simCardRepository;

    public SimCardDTO addNewSimCard(SimCardDTO newSim) {
        return toSimCardDTO(simCardRepository.save(toSimCard(newSim)));
    }

    public List<SimCardDTO> getAllSimCards() {
        return simCardRepository.findAll()
                .stream()
                .map(sim -> toSimCardDTO(sim))
                .collect(Collectors.toList());
    }

    public SimCardDTO updateSimCardDetails(String id, SimCardDTO updatedSim) {
        if(!simCardRepository.existsById(id)){
            return null;
        }
        SimCard simCard = simCardRepository.findById(id).get();

        Optional.ofNullable(updatedSim.getExpiryDate())
                .ifPresent(date -> simCard.setExpiryDate(date));
        Optional.ofNullable(updatedSim.getFullName())
                .ifPresent(name -> simCard.setFullName(name));
        Optional.ofNullable(updatedSim.getKyc())
                .ifPresent(kyc -> simCard.setKyc(kyc));
        Optional.ofNullable(updatedSim.getTelecomProvider())
                .ifPresent(provider -> simCard.setTelecomProvider(provider));

        return toSimCardDTO(simCardRepository.save(simCard));
    }

    public String deleteSimCardDetails(String id) {
        if(simCardRepository.existsById(id)){
            simCardRepository.deleteById(id);
            return "SimCard with id = " + id + " has been deleted!";
        }
        return "SimCard not found. Incorrect Id!";
    }

    public List<SimCardDTO> aboutToExpireIn30Days() {
        return simCardRepository.getAllSimCardsExpiringIn30Days()
                .stream()
                .map(sim -> toSimCardDTO(sim))
                .collect(Collectors.toList());
    }

    public SimCardDTO renewSim(String id, LocalDate expiryDate) {
        if(!simCardRepository.existsById(id)){
            return null;
        }
        SimCard simCard = simCardRepository.findById(id).get();
        simCard.setExpiryDate(expiryDate);

        return toSimCardDTO(simCardRepository.save(simCard));
    }

}
