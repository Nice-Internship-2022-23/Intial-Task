package com.medicine.Patient;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Disease {
    private String diseaseId;
    private String diseaseName;
    private ArrayList<String> diseaseSymptomps;
    private ArrayList<String> diseaseCuration;
}
