package com.microservices.Disease.Services;

import java.util.ArrayList;
import java.util.List;

import com.microservices.Disease.Entities.Disease;

public interface DiseaseServices {
    
    public String home();
    
    public Disease get(String diseaseId);

    public List<Disease> getAll();

    public String create(Disease disease);

    public String delete(String diseaseId);

    public ArrayList<String> getSymptoms(String diseaseName);

    public ArrayList<String> getCure(String diseaseName);

}
