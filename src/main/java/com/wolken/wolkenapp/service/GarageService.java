package com.wolken.wolkenapp.service;

import java.util.List;

import com.wolken.wolkenapp.dto.GarageDTO;

public interface GarageService {

	public String validateAndAdd(GarageDTO garageDTO);

	public List<GarageDTO> validateAndGetAll();

	public String validateAndUpdatePriceByName(double newPrice, String nameToBeUpdated);

	public String validateAndDeleteByName(String nameToBeDeleted);

}
