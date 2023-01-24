package com.medicine.Patient.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.medicine.Patient.Entities.Disease;
import com.medicine.Patient.Entities.Patient;
import com.medicine.Patient.Repository.PatientRepo;

@Service
public class PatientServiceImp implements PatientServices{

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String createPatient(Patient patient) {
        patientRepo.save(patient);
        return "Patient created successfully.";
    }

    @Override
    public Patient getPatient(String pId) {
        if(patientRepo.existsById(pId)){
            Patient patient = patientRepo.findById(pId).get();
            @SuppressWarnings("unchecked")
            ArrayList<String> symptomsList = restTemplate.getForObject("http://DISEASE-DATA/disease/getsymptoms/"+patient.getPatientDisease(), ArrayList.class);
            @SuppressWarnings("unchecked")
            ArrayList<String> curationList = restTemplate.getForObject("http://DISEASE-DATA/disease/getcure/"+patient.getPatientDisease(), ArrayList.class);
            Disease disease = new Disease();
            disease.setDiseaseCuration(curationList);
            disease.setDiseaseName(patient.getPatientDisease());
            disease.setDiseaseSymptomps(symptomsList);
            disease.setDiseaseId(pId);
            patient.setDisease(disease);
            return patient;
        }
        return new Patient();
    }

    @Override
    public List<Patient> getPatients() {
        List<Patient> patientList = new ArrayList<>();
        for(Patient patient : patientRepo.findAll()){
            @SuppressWarnings("unchecked")
            ArrayList<String> symptomsList = restTemplate.getForObject("http://DISEASE-DATA/disease/getsymptoms/"+patient.getPatientDisease(), ArrayList.class);
            @SuppressWarnings("unchecked")
            ArrayList<String> curationList = restTemplate.getForObject("http://DISEASE-DATA/disease/getcure/"+patient.getPatientDisease(), ArrayList.class);
            Disease disease = new Disease();
            disease.setDiseaseCuration(curationList);
            disease.setDiseaseName(patient.getPatientDisease());
            disease.setDiseaseSymptomps(symptomsList);
            patient.setDisease(disease);
            patientList.add(patient);
        }
        return patientList;
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
