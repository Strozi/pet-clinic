package com.strozi.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "VETS")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "VET_SPECIALTIES",
            joinColumns = @JoinColumn(name = "VET_ID"),
            inverseJoinColumns = @JoinColumn(name = "SPECIALITY_ID"))
    private Set<Speciality> specialities = new HashSet<>();
}
