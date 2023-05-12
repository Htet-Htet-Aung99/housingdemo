package com.example.housingdemo.dao;

import com.example.housingdemo.entity.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseOwnerDao extends JpaRepository<HouseOwner,Integer> {
}
