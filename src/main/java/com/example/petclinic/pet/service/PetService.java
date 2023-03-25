package com.example.petclinic.pet.service;

import com.example.petclinic.owner.Owner;
import com.example.petclinic.pet.Pet;
import com.example.petclinic.pet.repository.PetRepository;
import com.example.petclinic.visit.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet findPetById(Long id){
        return petRepository.findById(id).orElse(null);
    }

    public List<Pet> findAllPets(){
        return (List<Pet>) petRepository.findAll();
    }

    public Pet updatePet(Long id, Pet pet){
        Pet petToUpdate = petRepository.findById(id).orElse(null);
        petToUpdate.setName(pet.getName());
        petToUpdate.setType(pet.getType());
        petToUpdate.setOwner(pet.getOwner());
        petToUpdate.setDateOfBirth(pet.getDateOfBirth());
        return petRepository.save(petToUpdate);
    }

    public void deletePet(Long id){
        petRepository.deleteById(id);
    }

    public Pet linkOwnerToPet(Owner owner, Long id){
        Pet petToUpdate = petRepository.findById(id).orElse(null);
        petToUpdate.setOwner(owner);
        return petRepository.save(petToUpdate);
    }

    public Pet addVisit(Visit visit, Pet pet){
        List<Visit> visits = pet.getVisits();
        visits.add(visit);
        pet.setVisits(visits);
        return petRepository.save(pet);
    }
}
