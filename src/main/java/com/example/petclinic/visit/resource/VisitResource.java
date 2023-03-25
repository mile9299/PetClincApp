package com.example.petclinic.visit.resource;

import com.example.petclinic.pet.Pet;
import com.example.petclinic.pet.service.PetService;
import com.example.petclinic.vet.Veterinarian;
import com.example.petclinic.vet.service.VeterinarianService;
import com.example.petclinic.visit.Visit;
import com.example.petclinic.visit.service.VisitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitResource {
    final VisitService visitService;
    final PetService petService;
    final VeterinarianService veterinarianService;

    public VisitResource(VisitService visitService, PetService petService, VeterinarianService veterinarianService) {
        this.visitService = visitService;
        this.petService = petService;
        this.veterinarianService = veterinarianService;
    }

    @PostMapping("/pet/{petId}/vet/{vetId}")
    public Visit createVisit(@RequestBody Visit visit, @PathVariable("petId") Long petId, @PathVariable("vetId") Long vetId){
        Pet pet = this.petService.findPetById(petId);
        Veterinarian vet = this.veterinarianService.findVet(vetId);
        visit.setPet(pet);
        visit.setVeterinarian(vet);
        pet = this.petService.addVisit(visit,pet);
        vet = this.veterinarianService.addVisit(visit, vet);
        return this.visitService.createVisit(visit);
    }

    @GetMapping()
    public List<Visit> findVisits(){
        return this.visitService.findVisits();
    }

    @GetMapping("{id}")
    public Visit findVisit(@PathVariable Long id){
        return this.visitService.findVisit(id);
    }

    @DeleteMapping("{id}")
    public void deleteVisit(@PathVariable Long id){
        this.visitService.deleteVisit(id);
    }

}
