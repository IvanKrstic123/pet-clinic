package com.petclinic.bootstrap;

import model.Owner;
import model.Person;
import model.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import services.OwnerService;
import services.VetService;

// kada Spring Context uoci ovu komponentu videce da implementira CommnandLineRunner
// i pokrenuce run
@Component
@PropertySources({
        @PropertySource("classpath:owner.properties")
})
@PropertySource("classpath:owner.properties")
public class DataLoader implements CommandLineRunner {

    @Autowired
    public Environment environment;
    private final OwnerService ownerService;
    private final VetService vetService;


    @Value("${guru.owner.name}")
    private String name;
    @Value("${guru.owner.surname}")
    private String surname;

    @Value("${guru.owner2.name}")
    private String name2;
    @Value("${guru.owner2.surname}")
    private String surname2;

    /** iz YAML-a **/
    @Value("${guru.owner3.name}")
    private String name3;
    @Value("${guru.owner3.surname}")
    private String surname3;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        /** Owners podaci iz eksternog fajla **/
        Owner owner1 = new Owner();
        owner1.setFirstName(name);
        owner1.setLastName(surname);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName(name2);
        owner2.setLastName(surname2);

        ownerService.save(owner2);

        /** povlacimo podatke iz environment-a**/
        Owner owner3 = new Owner();
        owner3.setFirstName(environment.getProperty("name"));
        owner3.setLastName(environment.getProperty("surname"));

        ownerService.save(owner3);

        /** smestamo podatke iz YAML-a**/
        Owner owner4 = new Owner();
        owner4.setFirstName(name3);
        owner4.setLastName(surname3);

        ownerService.save(owner4);

        System.out.println("Owners Loaded!");

        /** Vets podaci **/
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Vets loadled!");

    }
}
