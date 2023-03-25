package com.example.petclinic.visit.repository;

import com.example.petclinic.visit.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
