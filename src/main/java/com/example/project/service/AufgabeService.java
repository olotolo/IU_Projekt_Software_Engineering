package com.example.project.service;

import com.example.project.entity.Aufgabe;

import java.util.List;

public interface AufgabeService {

    List<Aufgabe> findAll();

    Aufgabe findById(int theId);

    Aufgabe save(Aufgabe aufgabe);

    void deleteById(int theId);

}
