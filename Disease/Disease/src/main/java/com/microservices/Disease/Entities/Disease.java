package com.microservices.Disease.Entities;


import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Disease {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID")
    private String diseaseId;

    @Column(name = "DNAME")
    private String diseaseName;

    @Column(name = "DSYMPTOM")
    private String diseaseSymptomps;

    @Column(name = "DCURE")
    private String diseaseCuration;
}
