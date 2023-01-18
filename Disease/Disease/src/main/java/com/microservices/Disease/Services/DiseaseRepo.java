package com.microservices.Disease.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.Disease.Entities.Disease;

@Repository
public interface DiseaseRepo extends JpaRepository<Disease, String>{
    
}
