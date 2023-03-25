package com.example.petclinic.pet;

import com.example.petclinic.enums.PetType;
import com.example.petclinic.owner.Owner;
import com.example.petclinic.visit.Visit;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private Date dateOfBirth;
    @Column
    @Enumerated(EnumType.STRING)
    private PetType type;
    @JsonBackReference
    @ManyToOne(targetEntity = Owner.class)
    private Owner owner;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Visit.class, mappedBy = "pet")
    private List<Visit> visits;
}
