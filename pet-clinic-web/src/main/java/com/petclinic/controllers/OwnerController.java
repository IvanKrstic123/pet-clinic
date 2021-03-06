package com.petclinic.controllers;

import model.Owner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.OwnerService;

@RequestMapping("/owners")
@Controller()
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(@Lazy OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/"})
    public String listOwners(Model model)
    {
        model.addAttribute("owners", ownerService.findAll());

        return "owners/index.html";
    }

    @RequestMapping({"/find"})
    public String findOwners(){
        return "notimplemented";
    }
}
