package com.microservices.Disease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DiseaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiseaseApplication.class, args);
	}

}
