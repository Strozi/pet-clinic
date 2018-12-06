package com.strozi.petclinic.repositories;

import com.strozi.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;


public interface VetRepository extends CrudRepository<Vet, Long> {
}
