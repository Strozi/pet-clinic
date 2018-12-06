package com.strozi.petclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "VISITS")
public class Visit extends BaseEntity{

    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "DESCRIPTION")
    private String descrition;

    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private Pet pet;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}