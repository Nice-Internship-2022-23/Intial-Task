package com.medicine.Patient.Controllers;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.Patient.Entities.Patient;
import com.medicine.Patient.Service.PatientServices;

@RestController
@RequestMapping("/patients")
@Validated
public class PatientController {
    
    @Autowired
    private PatientServices patientService;

    @GetMapping
    public String home(){
        return "Hello world! welcom to Hospital Service";
    }

    @GetMapping("/getall")
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }

    @GetMapping("/get/{pId}")
    public Patient getPatient(@PathVariable @NotBlank(message = "Please provide patient id carefully!!!") String pId){
        return patientService.getPatient(pId);
    }

    @PostMapping("/create")
    public String createPatient(@RequestBody Patient patient){
        return patientService.createPatient(patient);
    }

    @DeleteMapping("/delete/{pId}")
    public String deletePatient(@PathVariable @NotBlank(message = "Please provide patient id carefully!!!") String pId){
        return patientService.deletePatient(pId);
    }

}
