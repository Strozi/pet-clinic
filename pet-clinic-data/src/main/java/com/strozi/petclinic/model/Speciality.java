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
@Table(name = "SPECIALTIES")
public class Speciality extends BaseEntity{
    @Column(name = "DESCRIPTION")
    private String description;
}
