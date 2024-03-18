package com.example.project.dao;

import com.example.project.entity.Mitarbeiter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MitarbeiterRepository extends JpaRepository<Mitarbeiter, Integer> {
	
	@Query("select m from Mitarbeiter m where m.rolle = ?1")
	List<Mitarbeiter> findByRolle(String rolle);
	
	@Query("select m from Mitarbeiter m join fetch m.projekt p where p.projektid = ?1")
	List<Mitarbeiter> findByProjekt(int projektid);
	
	@Query("select m from Mitarbeiter m where m.rolle = ?1 and m not in (select m from Mitarbeiter m join m.projekt p where (select count(*) from m.projekt) >= 3)")
	List<Mitarbeiter> findByCount(String rolle);
	
}
