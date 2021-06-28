package com.petclinic;

import com.petclinic.bootstrap.DataLoader;
import com.petclinic.controllers.OwnerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import services.springdatajpa.OwnerSDJpaService;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("model")
@ComponentScan(basePackageClasses = {OwnerController.class, OwnerSDJpaService.class, DataLoader.class })
public class PetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);
	}
}
