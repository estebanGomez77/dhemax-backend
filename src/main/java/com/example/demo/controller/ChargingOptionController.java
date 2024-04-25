package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ChargePoint;
import com.example.demo.models.ResponseOptions;
import com.example.demo.service.ChargePointService;

@RestController
@RequestMapping ("/bestChargingOption")
public class ChargingOptionController {

	@Autowired
	private ChargePointService chargePointService;

	@GetMapping
	private ResponseEntity<ResponseOptions> bestOption (@RequestParam("latitude") String lat,
			@RequestParam("longitude") String lon){
		
		return ResponseEntity.ok(chargePointService.findBestOption(lat,lon));
	}
	
}
