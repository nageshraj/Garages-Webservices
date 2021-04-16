package com.wolken.wolkenapp.dao;

import java.util.List;

import com.wolken.wolkenapp.dto.GarageDTO;

public interface GarageDAO {

	public String add(GarageDTO garageDTO);

	public List<GarageDTO> getAll();

	public String updatePricebyName(double newPrice, String nameToBeUpdated);

	public String deleteByName(String nameToBeDeleted);

}
