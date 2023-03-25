package com.example.petclinic.owner.service;

import com.example.petclinic.owner.Owner;
import com.example.petclinic.owner.repository.OwnerRepository;
import com.example.petclinic.pet.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    OwnerRepository ownerRepository;

    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner findOwnerById(int id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public List<Owner> findAllOwners() {
        return (List<Owner>) ownerRepository.findAll();
    }

    public void deleteOwner(int id){
        ownerRepository.deleteById(id);
    }

    public Owner updateOwner(int id, Owner owner) {
        Owner ownerToUpdate = ownerRepository.findById(id).orElse(null);
        ownerToUpdate.setFirstName(owner.getFirstName());
        ownerToUpdate.setLastName(owner.getLastName());
        ownerToUpdate.setAddress(owner.getAddress());
        ownerToUpdate.setCity(owner.getCity());
        ownerToUpdate.setTelephone(owner.getTelephone());
        ownerToUpdate.setPets(owner.getPets());
        return ownerRepository.save(ownerToUpdate);
    }

    public Owner linkPetToOwner(int id, Pet pet){
        Owner ownerToUpdate = ownerRepository.findById(id).orElse(null);
        List<Pet> pets = ownerToUpdate.getPets();
        pets.add(pet);
        ownerToUpdate.setPets(pets);
        return ownerRepository.save(ownerToUpdate);
    }
}
