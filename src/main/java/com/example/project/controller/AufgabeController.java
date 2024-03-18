package com.example.project.controller;

import com.example.project.entity.*;
import com.example.project.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/aufgaben")
public class AufgabeController {

    private AufgabeService aufgabeService;
    private MitarbeiterService mitarbeiterService;
    private ProjektService projektService;

    @Autowired
    public AufgabeController(AufgabeService aufgabeService, MitarbeiterService mitarbeiterService, ProjektService projektService ){
        this.aufgabeService = aufgabeService;
        this.mitarbeiterService = mitarbeiterService;
        this.projektService = projektService;
    }

    @GetMapping({"","/"})
    public String getAufgaben(Model theModel) {
        List<Aufgabe> meineAufgaben = aufgabeService.findAll();
        theModel.addAttribute("aufgabe", meineAufgaben);
        return "/aufgaben/aufgabe";
    }

    @GetMapping("/anlegen")
    public String showForm(Model theModel) {
        Aufgabe aufgabe = new Aufgabe();  
        aufgabe.setStatus("NEU");
        List<Projekt> projekte = projektService.findAll();
        theModel.addAttribute("aufgabe", aufgabe);       
        theModel.addAttribute("projekte", projekte);
        return "/aufgaben/aufgabe-anlegen";
    }

    @PostMapping("/save")
    public String saveAufgabe(@ModelAttribute("aufgabe") Aufgabe aufgabe) {
    	if(aufgabe.getProjektleiter() == null || aufgabe.getProjektleiter() == "") {
    		SecurityContext securityContext = SecurityContextHolder.getContext();    	
    		aufgabe.setProjektleiter(securityContext.getAuthentication().getName()); 
    	}
        aufgabeService.save(aufgabe);
        return "redirect:/aufgaben";
    }

    @GetMapping("/update")
    public String aufgabeUpdate(@RequestParam("aufgabeId")int id, Model theModel){
        Aufgabe aufgabe = aufgabeService.findById(id);
        List<Mitarbeiter> mitarbeiter = mitarbeiterService.findByProjekt(aufgabe.getProjektid().getProjektid());
        List<Projekt> projekte = projektService.findAll();
        theModel.addAttribute("aufgabe", aufgabe);
        theModel.addAttribute("mitarbeiter", mitarbeiter);
        theModel.addAttribute("projekte", projekte);
        return "/aufgaben/aufgabe-bearbeiten";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("aufgabeId") int theId) {
        aufgabeService.deleteById(theId);
        return "redirect:/aufgaben";
    }


}
