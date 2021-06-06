package com.petclinic.controllers;

import model.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.OwnerService;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

@RequestMapping("/owners")
@Controller()
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/"})
    public String listOwners(Model model)
    {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index.html";


    }
}
