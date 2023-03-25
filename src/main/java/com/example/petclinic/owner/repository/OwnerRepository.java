package com.example.petclinic.owner.repository;

import com.example.petclinic.owner.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner,Integer> {
}
