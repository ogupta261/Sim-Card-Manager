package com.handler.sim.mapper;

import com.handler.sim.domain.SimCard;
import com.handler.sim.domain.dto.SimCardDTO;

public class SimCardMapper {
    
    public static SimCard toSimCard(SimCardDTO sim) {
        return SimCard.builder()
                .simCardNo(sim.getSimCardNo())
                .expiryDate(sim.getExpiryDate())
                .fullName(sim.getFullName())
                .kyc(sim.getKyc())
                .mobileNo(sim.getMobileNo())
                .status(sim.isStatus())
                .stateOfRegistration(sim.getStateOfRegistration())
                .telecomProvider(sim.getTelecomProvider())
                .build();
    }

    public static SimCardDTO toSimCardDTO(SimCard sim) {
        return SimCardDTO.builder()
                .simCardNo(sim.getSimCardNo())
                .expiryDate(sim.getExpiryDate())
                .fullName(sim.getFullName())
                .kyc(sim.getKyc())
                .mobileNo(sim.getMobileNo())
                .status(sim.isStatus())
                .stateOfRegistration(sim.getStateOfRegistration())
                .telecomProvider(sim.getTelecomProvider())
                .build();
    }

}
