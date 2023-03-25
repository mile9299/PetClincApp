package com.example.petclinic.pet.resource;

import com.example.petclinic.owner.Owner;
import com.example.petclinic.owner.service.OwnerService;
import com.example.petclinic.pet.Pet;
import com.example.petclinic.pet.service.PetService;
import com.example.petclinic.vet.Veterinarian;
import com.example.petclinic.visit.Visit;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pets")
public class PetResource {
    private final PetService petService;
    private final OwnerService ownerService;

    public PetResource(PetService petService, OwnerService ownerService) {
        this.petService = petService;
        this.ownerService = ownerService;
    }

    @PostMapping("{id}")
    public Pet createPetAndLinkToOwner(@RequestBody Pet pet,@PathVariable("id") int ownerId){
        Owner petOwner = ownerService.findOwnerById(ownerId);
        pet.setOwner(petOwner);
        Pet petToSave = petService.createPet(pet);
        return petToSave;
    }
    @GetMapping
    public List<Pet> findAllPets(){
        return petService.findAllPets();
    }

    @GetMapping("{id}/get-owner")
    public Owner showPetOwner(@PathVariable("id") Long id){
        Pet pet = petService.findPetById(id);
        return pet.getOwner();
    }

    @GetMapping("{id}/get-visits")
    public List<Visit> getVisits(@PathVariable Long id) {
        Pet pet = this.petService.findPetById(id);
        return pet.getVisits();
    }

    @GetMapping("{id}")
    public Pet findPet(@PathVariable("id") Long id){
        return petService.findPetById(id);
    }

    @DeleteMapping("{id}")
    public void deletePet(@PathVariable("id") Long id){
        petService.deletePet(id);
    }

    @PutMapping("{id}")
    public Pet updatePet(@PathVariable("id") Long id, @RequestBody Pet pet){
        return petService.updatePet(id, pet);
    }

}
