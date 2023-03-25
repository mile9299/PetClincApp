package com.example.petclinic.vet.resource;

import com.example.petclinic.vet.Veterinarian;
import com.example.petclinic.vet.service.VeterinarianService;
import com.example.petclinic.visit.Visit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vets")
public class VeterinarianResource {
    private final VeterinarianService veterinarianService;

    public VeterinarianResource(VeterinarianService veterinarianService) {
        this.veterinarianService = veterinarianService;
    }

    @PostMapping
    public Veterinarian createVet(@RequestBody Veterinarian veterinarian){
        return this.veterinarianService.createVet(veterinarian);
    }

    @GetMapping
    public List<Veterinarian> getVets(){
        return this.veterinarianService.findAllVets();
    }

    @GetMapping("{id}")
    public Veterinarian getVet(@PathVariable Long id){
        return this.veterinarianService.findVet(id);
    }

    @GetMapping("{id}/get-visits")
    public List<Visit> getVisits(@PathVariable Long id) {
        Veterinarian veterinarian = this.veterinarianService.findVet(id);
        return veterinarian.getVisits();
    }

    @PutMapping("{id}")
    public Veterinarian updateVet(@PathVariable("id") Long id, @RequestBody Veterinarian veterinarian){
        return veterinarianService.updateVet(id, veterinarian);
    }

    @DeleteMapping("{id}")
    public void deleteVet(@PathVariable Long id){
        veterinarianService.deleteVet(id);
    }

}
