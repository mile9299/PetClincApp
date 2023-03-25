package com.example.petclinic.vet;

import com.example.petclinic.enums.Speciality;
import com.example.petclinic.visit.Visit;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Veterinarian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Visit.class, mappedBy = "veterinarian")
    private List<Visit> visits;

}
