package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ChargePoint;
import com.example.demo.service.ChargePointService;

@RestController
@RequestMapping ("/chargePoints")
public class ChargePointController {

	@Autowired
	private ChargePointService chargePointService;

	@GetMapping
	private ResponseEntity<List<ChargePoint>> getAllChargePoints (){
		return ResponseEntity.ok(chargePointService.findAll());
	}
	
	@GetMapping(value = "{id}", produces="application/json")
	private ResponseEntity<Optional<ChargePoint>> getAllChargePointsById (@PathVariable("id") Long idPunto){		
		return ResponseEntity.ok(chargePointService.findById(idPunto));   

	}
	
	@PostMapping
	private ResponseEntity<ChargePoint> insertChargePoints(@RequestBody ChargePoint cp){
		try {
			ChargePoint newCp = chargePointService.save(cp);		
		return ResponseEntity.created(new URI("/chargePoints/"+newCp.getId())).body(newCp);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
}
