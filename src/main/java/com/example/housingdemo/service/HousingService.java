package com.example.housingdemo.service;

import com.example.housingdemo.dao.HouseOwnerDao;
import com.example.housingdemo.dao.HousingDao;
import com.example.housingdemo.entity.HouseOwner;
import com.example.housingdemo.entity.Housing;
import com.example.housingdemo.model.HousingDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HousingService {
    private final HousingDao housingDao;
    private final HouseOwnerDao houseOwnerDao;

    public HousingService(HousingDao housingDao, HouseOwnerDao houseOwnerDao) {
        this.housingDao = housingDao;
        this.houseOwnerDao = houseOwnerDao;
    }
    @Transactional
    public Housing saveHousing(HousingDto housingDto){
        HouseOwner houseOwner=houseOwnerDao.findById(housingDto.getHouseOwnerId())
                .orElseThrow(EntityNotFoundException::new);
        Housing housing=toEntity(housingDto);
        houseOwner.addHousing(housing);
        return housingDao.save(housing);
    }
    private Housing toEntity(HousingDto housingDto){
        return new Housing(
                housingDto.getHousingName(),
                housingDto.getAddress(),
                housingDto.getNumberOfMasterRoom(),
                housingDto.getNumberOfSingleRoom(),
                housingDto.getAmount(),
                housingDto.getCreatedDate(),
                housingDto.getUpdatedDate()
        );
    }
    // HousingDto(String housingName, String address, int numberOfMasterRoom, int numberOfSingleRoom, int amount, LocalDate createdDate, LocalDate updatedDate,
//                      int houseOwnerId)
    public List<HousingDto> listAllHousings() {
        return housingDao.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private HousingDto toDto(Housing housing){
        return new HousingDto(
                housing.getHousingName(),
                housing.getAddress(),
                housing.getNumberOfMasterRoom(),
                housing.getNumberOfSingleRoom(),
                housing.getAmount(),
                housing.getCreatedDate(),
                housing.getUpdatedDate(),
                housing.getHouseOwner().getId());

    }
}
