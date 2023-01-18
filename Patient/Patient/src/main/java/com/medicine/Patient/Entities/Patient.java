package com.medicine.Patient.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID")
    private String patientId;

    @Column(name = "PNAME")
    private String patientName;

    @Column(name = "DOB")
    private String patientDateOfBirth;

    @Column(name = "PADDRESS")
    private String patientAddress;

    @Column(name = "PDISEASE")
    private String patientDisease;

    @Transient
    private Disease disease;
}
