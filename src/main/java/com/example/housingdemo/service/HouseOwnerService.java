package com.example.housingdemo.service;

import com.example.housingdemo.dao.HouseOwnerDao;
import com.example.housingdemo.entity.HouseOwner;
import org.springframework.stereotype.Service;

@Service
public class HouseOwnerService {
    private final HouseOwnerDao houseOwnerDao;

    public HouseOwnerService(HouseOwnerDao houseOwnerDao) {
        this.houseOwnerDao = houseOwnerDao;
    }

    public void saveHouseOwner(HouseOwner houseOwner){
        houseOwnerDao.save(houseOwner);
    }
}
