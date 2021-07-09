package com.petclinic.controllers;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.VetService;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(@Lazy VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","vets.html"})
    public String listVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index.html";
    }
}
