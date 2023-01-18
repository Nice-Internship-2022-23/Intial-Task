package com.medicine.Patient.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.Patient.Patient;

@Service
public class PatientServiceImp implements PatientServices{

    @Autowired
    private PatientRepo patientRepo;

    @Override
    public String createPatient(Patient patient) {
        patientRepo.save(patient);
        return "Patient created successfully.";
    }

    @Override
    public Patient getPatient(String pId) {
        if(patientRepo.existsById(pId)){
            return patientRepo.findById(pId).get();
        }
        return new Patient();
    }

    @Override
    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }

    @Override
    public String deletePatient(String pId) {
        if(patientRepo.existsById(pId)){
            patientRepo.deleteById(pId);
            return "Patient deleted successfully";
        }
        return "Patient with id : " + pId + " does not exist.";
    }
    
}
