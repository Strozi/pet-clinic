package com.strozi.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
public class Person extends BaseEntity{
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

}
