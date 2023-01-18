package com.microservices.Disease.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.Disease.Entities.Disease;


@Service
public class DiseaseServicesImp implements DiseaseServices{
    
    @Autowired
    private DiseaseRepo diseaseRepo;

    public String home(){
        return "Welcome to disease info service.";
    }

    public String create(Disease disease){
        diseaseRepo.save(disease);
        return "Created";
    }

    public String delete(String id){
        if(diseaseRepo.existsById(id)){
            diseaseRepo.deleteById(id);
            return "Deleted";
        }
        return "No Disease with id = " + id;
    }

    public Disease get(String id){
        if(diseaseRepo.existsById(id)){
            return diseaseRepo.findById(id).get();
        }
        else return new Disease();
    }

    public List<Disease> getAll(){
        return diseaseRepo.findAll();
    }

    @Override
    public ArrayList<String> getSymptoms(String diseaseName) {
        ArrayList<String> sList = new ArrayList<>();
        for(Disease disease : diseaseRepo.findAll()){
            if(disease.getDiseaseName().equalsIgnoreCase(diseaseName) && !disease.getDiseaseSymptomps().isEmpty()){
                sList.add(disease.getDiseaseSymptomps());
            }
        }
        return sList;
    }

    @Override
    public ArrayList<String> getCure(String diseaseName) {
        ArrayList<String> cList = new ArrayList<>();
        for(Disease disease : diseaseRepo.findAll()){
            if(disease.getDiseaseName().equalsIgnoreCase(diseaseName) && !disease.getDiseaseCuration().isEmpty()){
                cList.add(disease.getDiseaseCuration());
            }
        }
        return cList;
    }
}

