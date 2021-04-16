package com.wolken.wolkenapp.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.dao.GarageDAO;
import com.wolken.wolkenapp.dto.GarageDTO;

@Service
public class GarageServiceImpl implements GarageService {

	@Autowired
	GarageDAO garageDAO;

	Logger logger = Logger.getLogger("GarageServiceImpl");

	@Override
	public String validateAndAdd(GarageDTO garageDTO) {
		// TODO Auto-generated method stub

		logger.info("inside validateAndAdd()");
		if (garageDTO != null) {
			return garageDAO.add(garageDTO);
		}

		return "Not added successfully";
	}

	@Override
	public List<GarageDTO> validateAndGetAll() {
		// TODO Auto-generated method stub
		logger.info("inside validateAndGetAll()");
		return garageDAO.getAll();
	}

	@Override
	public String validateAndUpdatePriceByName(double newPrice, String nameToBeUpdated) {
		// TODO Auto-generated method stub
		logger.info("inside validateAndUpdatePriceByName()");

		if (newPrice != 0) {
			if (nameToBeUpdated != null) {
				return garageDAO.updatePricebyName(newPrice, nameToBeUpdated);

			}
		}

		return "Data could not be updated";
	}

	@Override
	public String validateAndDeleteByName(String nameToBeDeleted) {

		logger.info("inside validateAndDeleteByName()");

		// TODO Auto-generated method stub
		return garageDAO.deleteByName(nameToBeDeleted);
	}

}
