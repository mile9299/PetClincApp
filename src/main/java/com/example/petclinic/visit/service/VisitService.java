package com.example.petclinic.visit.service;

import com.example.petclinic.visit.Visit;
import com.example.petclinic.visit.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {
    @Autowired
    VisitRepository visitRepository;

    public Visit createVisit(Visit visit){
        return visitRepository.save(visit);
    }

    public Visit findVisit(Long id){
        return visitRepository.findById(id).orElse(null);
    }

    public List<Visit> findVisits(){
        return (List<Visit>) visitRepository.findAll();
    }

    public void deleteVisit(Long id){
        visitRepository.deleteById(id);
    }


}
