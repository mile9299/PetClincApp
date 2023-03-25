package com.example.petclinic.pet.repository;

import com.example.petclinic.pet.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PetRepository extends CrudRepository<Pet, Long> {
}
