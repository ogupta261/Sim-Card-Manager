package com.handler.sim.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "sim_card")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class SimCard implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    private String simCardNo;

    @NotNull
    @Column(nullable = false, updatable = false, length = 10, unique = true)
    @Size(min = 10, max = 10)
    private String mobileNo;

    @NotNull
    @Column(nullable = false)
    private boolean status;

    @NotNull
    @Column(nullable = false)
    private LocalDate expiryDate;

    @NotNull
    @Column(nullable = false)
    private String stateOfRegistration;

    @NotNull
    @Column(nullable = false)
    private String kyc;

    @NotNull
    @Column(nullable = false)
    private String telecomProvider;

    @NotNull
    @Column(nullable = false, length = 50)
    @Size(min = 3, max = 50)
    private String fullName;
    
}
