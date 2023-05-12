package com.example.housingdemo.controller;

import com.example.housingdemo.entity.HouseOwner;
import com.example.housingdemo.service.HouseOwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class HouseOwnerController {
    private final HouseOwnerService houseOwnerService;

    public HouseOwnerController(HouseOwnerService houseOwnerService) {
        this.houseOwnerService = houseOwnerService;
    }

    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("success",model.containsAttribute("success"));
        return "home";
    }
    @GetMapping("/house-owner-form")
    public String houseOwnerForm(Model model){
        model.addAttribute("houseOwner",new HouseOwner());
        return "houseOwnerForm";
    }
    @PostMapping("/house-owner-form")
    public String saveHouseOwner(@Valid HouseOwner houseOwner, BindingResult result,RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "houseOwnerForm";
        }
        houseOwnerService.saveHouseOwner(houseOwner);
        redirectAttributes.addFlashAttribute("success",true);
        return "redirect:/";

    }
}
