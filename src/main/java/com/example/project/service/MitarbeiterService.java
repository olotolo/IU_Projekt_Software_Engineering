package com.example.project.service;

import com.example.project.entity.Mitarbeiter;

import java.util.List;

public interface MitarbeiterService {

    List<Mitarbeiter> findAll();
    
    List<Mitarbeiter> findByRolle();     
    
    List<Mitarbeiter> findByProjekt(int projektid);
    
    List<Mitarbeiter> findByCount();

}
