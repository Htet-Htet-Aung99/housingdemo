package com.example.housingdemo.controller;

import com.example.housingdemo.entity.Housing;
import com.example.housingdemo.model.HousingDto;
import com.example.housingdemo.service.HousingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HousingController {

    private final HousingService housingService;

    public HousingController(HousingService housingService) {
        this.housingService = housingService;
    }

    @PostMapping("/housings")
    public ResponseEntity<Housing>  createHousing(@RequestBody @Valid HousingDto housingDto, HttpServletRequest request){
        Housing housing=housingService.saveHousing(housingDto);
        return ResponseEntity.created(URI.create(request.getContextPath()+"/api/housing")).body(housing);
    }
    @GetMapping("/public/housings")
    public List<HousingDto> listAllHousings(){
        return housingService.listAllHousings();
    }
}
