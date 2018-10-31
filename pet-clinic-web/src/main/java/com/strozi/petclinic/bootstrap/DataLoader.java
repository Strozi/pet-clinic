package com.strozi.petclinic.bootstrap;

import com.strozi.petclinic.model.Owner;
import com.strozi.petclinic.model.Vet;
import com.strozi.petclinic.services.OwnerService;
import com.strozi.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Josh");
        owner1.setId(1L);
        owner1.setLastName("Long");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Tom");
        owner2.setId(2L);
        owner2.setLastName("Hardy");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Tobby");
        vet1.setLastName("Young");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Bobby");
        vet2.setLastName("Chang");

        vetService.save(vet2);


    }
}