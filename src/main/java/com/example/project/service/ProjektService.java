package com.example.project.service;

import com.example.project.entity.Projekt;

import java.util.List;

public interface ProjektService {

    List<Projekt> findAll();

    Projekt findById(int theId);

    Projekt save(Projekt projekt);

    void deleteById(int theId);

}
