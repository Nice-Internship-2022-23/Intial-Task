package com.microservices.Disease.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.Disease.Entities.Disease;
import com.microservices.Disease.Services.DiseaseServicesImp;

@RestController
@RequestMapping("/disease")
public class DiseaseController {
    
    @Autowired
    private DiseaseServicesImp diseaseServices;

    @GetMapping
    public String home(){
        return diseaseServices.home();
    }

    @GetMapping("/getsymptoms/{name}")
    public ArrayList<String> getSymptoms(@PathVariable String name){
        return diseaseServices.getSymptoms(name);
    }

    @GetMapping("/getcure/{name}")
    public ArrayList<String> getCuration(@PathVariable String name){
        return diseaseServices.getCure(name);
    }

    @GetMapping("/get/{id}")
    public Disease getDisease(@PathVariable String id){
        return diseaseServices.get(id);
    }

    @GetMapping("/getall")
    public List<Disease> getalldiseases(){
        return diseaseServices.getAll();
    }

    @PostMapping("/create")
    public String create(@RequestBody Disease disease){
        return diseaseServices.create(disease);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        return diseaseServices.delete(id);
    }

}

