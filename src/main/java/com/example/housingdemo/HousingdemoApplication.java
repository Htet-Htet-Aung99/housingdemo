package com.example.housingdemo;

import com.example.housingdemo.model.HousingDto;
import com.example.housingdemo.service.HousingService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootApplication
public class HousingdemoApplication {

    private final HousingService housingService;

    public HousingdemoApplication(HousingService housingService) {
        this.housingService = housingService;
    }
    //HousingDto(String housingName, String address, int numberOfMasterRoom, int numberOfSingleRoom, int amount, LocalDate createdDate, LocalDate updatedDate,
    //                      int houseOwnerId)
    @Transactional
    @Bean @Profile("dev")
    public ApplicationRunner runner(){
        return r ->{
            HousingDto housingDto1=new HousingDto("HouseA","Mdy",1,2,3000, LocalDate.now(),
                    LocalDate.now(),1);
            HousingDto housingDto2=new HousingDto("HouseB","Mdy",1,3,3500, LocalDate.now(),
                    LocalDate.now(),1);
            housingService.saveHousing(housingDto1);
            housingService.saveHousing(housingDto2);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(HousingdemoApplication.class, args);
    }

}
