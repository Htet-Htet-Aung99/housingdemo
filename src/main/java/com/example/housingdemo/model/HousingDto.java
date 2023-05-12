package com.example.housingdemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class HousingDto {

    private String housingName;
    private String address;
    private int numberOfMasterRoom;
    private int numberOfSingleRoom;
    private int amount;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private int houseOwnerId;

    public HousingDto(){

    }

    public HousingDto(String housingName, String address, int numberOfMasterRoom, int numberOfSingleRoom, int amount, LocalDate createdDate, LocalDate updatedDate,
                      int houseOwnerId) {
        this.housingName = housingName;
        this.address = address;
        this.numberOfMasterRoom = numberOfMasterRoom;
        this.numberOfSingleRoom = numberOfSingleRoom;
        this.amount = amount;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.houseOwnerId = houseOwnerId;
    }
}
