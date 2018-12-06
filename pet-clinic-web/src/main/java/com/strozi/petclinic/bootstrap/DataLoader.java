package com.strozi.petclinic.bootstrap;

import com.strozi.petclinic.model.*;
import com.strozi.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count ==0) {
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

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

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(tomPet);
        catVisit.setDescrition("Sneezy Kitty :)");

        visitService.save(catVisit);

        Visit dogVisit = new Visit();
        dogVisit.setDate(LocalDate.now());
        dogVisit.setPet(joshPet);
        dogVisit.setDescrition("Injured doggy :(");

        visitService.save(dogVisit);

        Vet vet1 = new Vet();
        vet1.setFirstName("Tobby");
        vet1.setLastName("Young");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bobby");
        vet2.setLastName("Chang");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);
    }
}
