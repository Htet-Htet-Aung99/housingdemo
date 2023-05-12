package com.example.housingdemo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class HouseOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "OwnerUserName cannot be blank.")
    @NotEmpty(message = "OwnerUserName cannot be empty!")
    private String ownerUserName;
    @NotBlank(message = "OwnerName cannot be blank.")
    @NotEmpty(message = "OwnerName cannot be empty!")
    private String ownerName;
    @Email(message = "Invalid Email Format!")
    @NotBlank(message = "OwnerEmail cannot be blank.")
    @NotEmpty(message = "OwnerEmail cannot be empty!")
    private String ownerEmail;
    @NotBlank(message = "Password cannot be blank.")
    @NotEmpty(message = "Password cannot be empty!")
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedDate;
    @JsonIgnore
    @OneToMany(mappedBy = "houseOwner")
    private List<Housing> housings=
            new ArrayList<>();

    public HouseOwner(){

    }

    public HouseOwner(String ownerUserName, String ownerName, String ownerEmail, String password, LocalDate createdDate, LocalDate updatedDate) {
        this.ownerUserName = ownerUserName;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.password = password;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public void addHousing(Housing housing){
        housing.setHouseOwner(this);
        housings.add(housing);
    }




}
