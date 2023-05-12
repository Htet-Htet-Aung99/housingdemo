package com.example.housingdemo.dao;

import com.example.housingdemo.entity.Housing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HousingDao extends JpaRepository<Housing,Integer> {
}
