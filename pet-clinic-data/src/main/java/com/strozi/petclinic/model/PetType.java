package com.strozi.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PET_TYPES")
public class PetType extends BaseEntity{

    @Column(name = "NAME")
    private String name;
}
