package com.example.project.dao;

import com.example.project.entity.Aufgabe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AufgabeRepository extends JpaRepository<Aufgabe, Integer> {
	
	@Query("select a from Aufgabe a where a.projektleiter = ?1")
	List<Aufgabe> findByProjektleiter(String projektleiter);
	
	@Query("select a from Aufgabe a where a.mitarbeiter = ?1")
	List<Aufgabe> findByMitarbeiter(String mitarbeiter);
	
}
