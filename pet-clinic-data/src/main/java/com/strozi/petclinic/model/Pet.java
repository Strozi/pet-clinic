package com.strozi.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PETS")
public class Pet extends BaseEntity{

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "PET_TYPE")
    private PetType type;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

}
