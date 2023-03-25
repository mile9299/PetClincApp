package com.example.petclinic.visit;

import com.example.petclinic.pet.Pet;
import com.example.petclinic.vet.Veterinarian;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String description;
    @CreationTimestamp
    @Column(nullable = false)
    private Date createdAt;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Pet.class)
    private Pet pet;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Veterinarian.class)
    private Veterinarian veterinarian;
}
