package com.medicine.Patient.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicine.Patient.Entities.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, String>{
     
}
