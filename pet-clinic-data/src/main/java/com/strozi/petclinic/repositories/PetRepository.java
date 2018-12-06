package com.strozi.petclinic.repositories;

import com.strozi.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;


public interface PetRepository extends CrudRepository<Pet, Long> {
}
