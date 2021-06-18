package com.petclinic;

import com.petclinic.bootstrap.DataLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import services.springdatajpa.OwnerSDJpaService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {OwnerRepo.class, DataLoader.class, OwnerSDJpaService.class})
public class PetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);
	}

}