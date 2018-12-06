package com.strozi.petclinic.repositories;

import com.strozi.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;



public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
