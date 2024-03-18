package com.example.project.service;

import com.example.project.dao.ProjektRepository;
import com.example.project.entity.Projekt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
public class ProjektServiceImpl implements ProjektService{

    private ProjektRepository projektRepository;

    @Autowired
    public ProjektServiceImpl(ProjektRepository projektRepository){
        this.projektRepository = projektRepository;
    }

    @Override
    public List<Projekt> findAll() {
    	SecurityContext securityContext = SecurityContextHolder.getContext();      	
    	if(securityContext.getAuthentication().getAuthorities().toString().equals("[ROLE_MANAGER]")) {
    		return projektRepository.findAll();
    	} else {
    		return projektRepository.findByName(securityContext.getAuthentication().getName());
    	}        
    }
    
    @Override
    public Projekt save (Projekt projekt){
        return projektRepository.save(projekt);
    }    

    @Override
    public Projekt findById(int theId) {
        Optional<Projekt> result = projektRepository.findById(theId);
        Projekt projekt = null;
        if (result.isPresent()) {
            projekt = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find projekt id: " + theId);
        }
        return projekt;
    }

    @Override
    public void deleteById(int theId) {
        projektRepository.deleteById(theId);

    }
    
}
