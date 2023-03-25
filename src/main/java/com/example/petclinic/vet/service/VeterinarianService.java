package com.example.petclinic.vet.service;

import com.example.petclinic.vet.Veterinarian;
import com.example.petclinic.vet.repository.VeterinarianRepository;
import com.example.petclinic.visit.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarianService {
    @Autowired
    VeterinarianRepository veterinarianRepository;

    public Veterinarian createVet(Veterinarian veterinarian){
        return veterinarianRepository.save(veterinarian);
    }

    public Veterinarian findVet(Long id){
        return veterinarianRepository.findById(id).orElse(null);
    }

    public List<Veterinarian> findAllVets(){
        return (List<Veterinarian>) veterinarianRepository.findAll();
    }

    public void deleteVet(Long id){
        veterinarianRepository.deleteById(id);
    }

    public Veterinarian updateVet(Long id, Veterinarian vet){
        Veterinarian vetToUpdate = veterinarianRepository.findById(id).orElse(null);
        vetToUpdate.setFirstName(vet.getFirstName());
        vetToUpdate.setLastName(vet.getLastName());
        vetToUpdate.setSpeciality(vet.getSpeciality());
        return veterinarianRepository.save(vetToUpdate);
    }

    public Veterinarian addVisit(Visit visit, Veterinarian veterinarian){
        List<Visit> visits = veterinarian.getVisits();
        visits.add(visit);
        veterinarian.setVisits(visits);
        return veterinarianRepository.save(veterinarian);
    }
}
