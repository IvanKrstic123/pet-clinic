package com.petclinic;

import com.petclinic.bootstrap.DataLoader;
import com.petclinic.controllers.OwnerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import services.map.OwnerServiceMap;

@SpringBootApplication
@ComponentScan(basePackageClasses = {OwnerController.class, OwnerServiceMap.class, DataLoader.class})
public class PetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);
	}

}
