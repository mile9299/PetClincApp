package com.example.petclinic.owner.resource;

import com.example.petclinic.owner.Owner;
import com.example.petclinic.owner.service.OwnerService;
import com.example.petclinic.pet.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerResource {
    private final OwnerService ownerService;

    public OwnerResource(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping()
    public Owner createOwner(@RequestBody Owner owner){
        return ownerService.createOwner(owner);
    }

    @GetMapping()
    public List<Owner> getAllOwners(){
        return ownerService.findAllOwners();
    }

    @GetMapping("{id}")
    public Owner getOwner(@PathVariable("id") int id){
        return ownerService.findOwnerById(id);
    }

    @GetMapping("{id}/get-pets")
    public List<Pet> getPets(@PathVariable int id) {
        Owner owner = this.ownerService.findOwnerById(id);
        return owner.getPets();
    }

    @DeleteMapping("{id}")
    public void deleteOwner(@PathVariable("id") int id){
        ownerService.deleteOwner(id);
    }

    @PutMapping("{id}")
    public Owner updateOwner(@PathVariable("id") int id, @RequestBody Owner owner){
        return ownerService.updateOwner(id,owner);
    }
}
