package com.medicine.Patient.Service;

import java.util.List;

import com.medicine.Patient.Patient;

public interface PatientServices {
    
    public String createPatient(Patient patient);

    public List<Patient> getPatients();

    public Patient getPatient(String pId);

    public String deletePatient(String pId);
}
