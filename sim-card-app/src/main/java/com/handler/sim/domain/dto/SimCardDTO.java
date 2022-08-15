package com.handler.sim.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class SimCardDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String simCardNo;

    private String mobileNo;

    private boolean status;

    private LocalDate expiryDate;

    private String stateOfRegistration;

    private String kyc;

    private String telecomProvider;

    private String fullName;

}
