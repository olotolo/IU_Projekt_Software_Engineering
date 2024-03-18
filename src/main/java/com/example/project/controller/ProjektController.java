package com.example.project.controller;

import com.example.project.entity.*;
import com.example.project.service.MitarbeiterService;
import com.example.project.service.ProjektService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


@Controller
@RequestMapping("/projekte")
public class ProjektController {

    private ProjektService projektService;  
    private MitarbeiterService mitarbeiterService;
      
    @Autowired
    public ProjektController (ProjektService projektService, MitarbeiterService mitarbeiterService ){
        this.projektService = projektService;
        this.mitarbeiterService = mitarbeiterService;
    }

	@GetMapping({"","/"})
    public String getProjekte(Model theModel) {
        List<Projekt> meineProjekte = projektService.findAll();
        theModel.addAttribute("projekt", meineProjekte);
        return "/projekte/projekt";
    }
    
    @GetMapping("/anlegen")
    public String showForm(Model theModel) {
        Projekt projekt = new Projekt();
        projekt.setStatus("NEU");
        List<Mitarbeiter> projektleiter = mitarbeiterService.findByRolle();       
        theModel.addAttribute("projekt", projekt);
        theModel.addAttribute("projektleiter", projektleiter);              
        return "/projekte/projekt-anlegen";
    }

    @PostMapping("/save")
    public String saveProjekt(@ModelAttribute("projekt") Projekt projekt) {
    	if(projekt.getErsteller() == null || projekt.getErsteller() == "") {
	    	SecurityContext securityContext = SecurityContextHolder.getContext();    	
	    	projekt.setErsteller(securityContext.getAuthentication().getName());
	    	String pattern = "yyyy-MM-dd";
	    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	    	String date = simpleDateFormat.format(new Date());   	
	    	projekt.setErstellDatum(date);
    	}
        projektService.save(projekt);
        return "redirect:/projekte";
    }

    @GetMapping("/update")
    public String projektUpdate(@RequestParam("projektId")int id, Model theModel){
        Projekt projekt = projektService.findById(id);
        List<Mitarbeiter> projektleiter = mitarbeiterService.findByRolle();
        if(projekt.getStatus().equals("NEU")) {
        	List<Mitarbeiter> mitarbeiter = mitarbeiterService.findByCount();
        	theModel.addAttribute("mitarbeiter", mitarbeiter);
        } else {
        	List<Mitarbeiter> union1 = mitarbeiterService.findByProjekt(id);
        	List<Mitarbeiter> union2 = mitarbeiterService.findByCount();
        	List<Mitarbeiter> mitarbeiter = new ArrayList<>();
        	mitarbeiter.addAll(union2);
        	boolean test = false;
        	for(Mitarbeiter a : union1) {       		
        		for (Mitarbeiter b : mitarbeiter) {
        			if(a.getId() == b.getId()) {
        				test = true;
        			}
        		}
        		if(!test) {
        			mitarbeiter.add(a);
        		}
        	}        	
        	theModel.addAttribute("mitarbeiter", mitarbeiter);
        }
        
        theModel.addAttribute("projekt", projekt);
        theModel.addAttribute("projektleiter", projektleiter);
        
        return "/projekte/projekt-bearbeiten";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("projektid") int theId) {
        projektService.deleteById(theId);
        return "redirect:/projekte";
    }


}
