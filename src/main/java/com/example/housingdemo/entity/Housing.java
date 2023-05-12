package com.example.housingdemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Housing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "HousingName cannot be empty!")
    @NotBlank(message = "HousingName cannot be blank!")
    private String housingName;
    @NotEmpty(message = "Address cannot be empty!")
    @NotBlank(message = "Address cannot be blank!")
    private String address;
    @Min(value = 1,message = "NumberOfMasterRoom cannot be less than one.")
    private int numberOfMasterRoom;
    @Min(value = 1,message = "NumberOfSingleRoom cannot be less than one.")
    private int numberOfSingleRoom;
    @Min(value = 1,message = "Amount cannot be zero.")
    private int amount;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    @JoinColumn(name = "owner_id")
    @ManyToOne
    private com.example.housingdemo.entity.HouseOwner houseOwner;

    public Housing(){

    }

    public Housing(String housingName, String address, int numberOfMasterRoom, int numberOfSingleRoom, int amount, LocalDate createdDate, LocalDate updatedDate) {
        this.housingName = housingName;
        this.address = address;
        this.numberOfMasterRoom = numberOfMasterRoom;
        this.numberOfSingleRoom = numberOfSingleRoom;
        this.amount = amount;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }




}
