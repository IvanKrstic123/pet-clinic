package com.petclinic.bootstrap;

import model.Owner;
import model.PetType;
import model.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import services.OwnerService;
import services.PetTypeService;
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
    private final PetTypeService petTypeService;


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


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);


        /** Owners podaci iz eksternog fajla **/
        Owner owner1 = new Owner();
        owner1.setFirstName(name);
        owner1.setLastName(surname);
        owner1.setAdress("Gorazdevac 239");
        owner1.setCity("Pec");
        owner1.setTelephone("123-456-789");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName(name2);
        owner2.setLastName(surname2);
        owner1.setAdress("Gorazdevac 240");
        owner1.setCity("Pec");
        owner1.setTelephone("123-777-789");

        ownerService.save(owner2);

        /** povlacimo podatke iz environment-a**/
        Owner owner3 = new Owner();
        owner3.setFirstName(environment.getProperty("name"));
        owner3.setLastName(environment.getProperty("surname"));
        owner1.setAdress("Gorazdevac 241");
        owner1.setCity("Pec");
        owner1.setTelephone("123-111-789");

        ownerService.save(owner3);

        /** smestamo podatke iz YAML-a**/
        Owner owner4 = new Owner();
        owner4.setFirstName(name3);
        owner4.setLastName(surname3);
        owner1.setAdress("Gorazdevac 242");
        owner1.setCity("Pec");
        owner1.setTelephone("457-456-789");

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
