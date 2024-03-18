package com.example.project.controller;

import com.example.project.entity.Mitarbeiter;
import com.example.project.service.MitarbeiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mitarbeiter")
public class MitarbeiterController {

    private MitarbeiterService mitarbeiterService;

    @Autowired
    public MitarbeiterController (MitarbeiterService mitarbeiterService){
        this.mitarbeiterService = mitarbeiterService;
    }

    @GetMapping
    public String getMitarbeiter(Model theModel) {
        List<Mitarbeiter> meineMitarbeiter = mitarbeiterService.findAll();
        theModel.addAttribute("Mitarbeiter", meineMitarbeiter);
        return "/mitarbeiter/mitarbeiter";
    }



}
