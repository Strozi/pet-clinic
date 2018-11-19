package com.strozi.petclinic.bootstrap;

import com.strozi.petclinic.model.Owner;
import com.strozi.petclinic.model.Pet;
import com.strozi.petclinic.model.PetType;
import com.strozi.petclinic.model.Vet;
import com.strozi.petclinic.services.OwnerService;
import com.strozi.petclinic.services.PetTypeService;
import com.strozi.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Josh");
        owner1.setLastName("Long");
        owner1.setAddress("123 Blabla St");
        owner1.setCity("Dallas");
        owner1.setTelephone("123456789");

        Pet joshPet = new Pet();
        joshPet.setType(savedDogPetType);
        joshPet.setOwner(owner1);
        joshPet.setBirthDate(LocalDate.now());
        joshPet.setName("Chowder");
        owner1.getPets().add(joshPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Tom");
        owner2.setLastName("Hardy");
        owner2.setAddress("49 Ice Cream Avenue");
        owner2.setCity("New York");
        owner2.setTelephone("666333666");

        Pet tomPet = new Pet();
        tomPet.setType(savedCatPetType);
        tomPet.setOwner(owner2);
        tomPet.setBirthDate(LocalDate.now());
        tomPet.setName("Mrumru II");
        owner2.getPets().add(tomPet);

        ownerService.save(owner2);
        Vet vet1 = new Vet();
        vet1.setFirstName("Tobby");
        vet1.setLastName("Young");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bobby");
        vet2.setLastName("Chang");

        vetService.save(vet2);


    }
}
