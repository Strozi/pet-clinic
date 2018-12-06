package com.strozi.petclinic.repositories;

import com.strozi.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;



public interface VisitRepository extends CrudRepository<Visit, Long> {
}
