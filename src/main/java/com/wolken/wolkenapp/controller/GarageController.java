package com.wolken.wolkenapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.dto.GarageDTO;
import com.wolken.wolkenapp.service.GarageService;

@RestController
public class GarageController {

	@Autowired
	GarageService garageService;

	@GetMapping("/getAll")
	public List<GarageDTO> getAll() {
		return garageService.validateAndGetAll();
	}

	@PostMapping("/save")
	public String save(@RequestBody GarageDTO garageDTO) {
		return garageService.validateAndAdd(garageDTO);
	}

	@PutMapping("/update")
	public String update(@RequestBody GarageDTO garageDTO) {
		return garageService.validateAndUpdatePriceByName(garageDTO.getPrice(), garageDTO.getName());
	}

	@DeleteMapping("/delete")
	public String del(@RequestBody GarageDTO garageDTO) {
		return garageService.validateAndDeleteByName(garageDTO.getName());
	}

}
