package com.strozi.petclinic.repositories;

import com.strozi.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;


public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
