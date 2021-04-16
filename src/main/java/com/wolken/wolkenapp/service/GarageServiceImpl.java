package com.wolken.wolkenapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.dao.GarageDAO;
import com.wolken.wolkenapp.dto.GarageDTO;

@Service
public class GarageServiceImpl implements GarageService {

	@Autowired
	GarageDAO garageDAO;

	@Override
	public String validateAndAdd(GarageDTO garageDTO) {
		// TODO Auto-generated method stub
		if (garageDTO != null) {
			return garageDAO.add(garageDTO);
		}

		return "Not added successfully";
	}

	@Override
	public List<GarageDTO> validateAndGetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validateAndUpdatePriceByName(double newPrice, String nameToBeUpdated) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validateAndDeleteByName(String nameToBeDeleted) {
		// TODO Auto-generated method stub
		return null;
	}

}
