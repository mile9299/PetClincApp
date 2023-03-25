package com.example.petclinic.vet.repository;

import com.example.petclinic.vet.Veterinarian;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VeterinarianRepository extends CrudRepository<Veterinarian,Long> {
}
