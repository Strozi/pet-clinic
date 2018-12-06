package com.strozi.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}