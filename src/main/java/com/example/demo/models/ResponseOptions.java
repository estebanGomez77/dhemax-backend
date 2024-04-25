package com.example.demo.models;

public class ResponseOptions {
	
	private ChargePoint chargePointBestDistance;
	private ChargePoint chargePointBestPower;
	
	public ResponseOptions(ChargePoint chargePointBestDistance, ChargePoint chargePointBestPower) {
		super();
		this.chargePointBestDistance = chargePointBestDistance;
		this.chargePointBestPower = chargePointBestPower;
	}
	
	public ResponseOptions() {
	}
	
	public ChargePoint getChargePointBestDistance() {
		return chargePointBestDistance;
	}
	public void setChargePointBestDistance(ChargePoint chargePointBestDistance) {
		this.chargePointBestDistance = chargePointBestDistance;
	}
	public ChargePoint getChargePointBestPower() {
		return chargePointBestPower;
	}
	public void setChargePointBestPower(ChargePoint chargePointBestPower) {
		this.chargePointBestPower = chargePointBestPower;
	}

}
