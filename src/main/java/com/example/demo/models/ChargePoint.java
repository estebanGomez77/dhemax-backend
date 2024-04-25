package com.example.demo.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "charge_points")
public class ChargePoint{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "points_generator")
	@SequenceGenerator(name = "points_generator", sequenceName = "charge_points_seq", allocationSize = 1)
	private Long id;
	
	private String status;
	private String operator;
	private Integer connections;
	private String latitude;
	private String longitude;
	private String country;
	private Integer power;
	
	public ChargePoint(String status, String operator, Integer connections, String latitude, String longitude,
			String country, Integer power) {
		super();
		this.status = status;
		this.operator = operator;
		this.connections = connections;
		this.latitude = latitude;
		this.longitude = longitude;
		this.country = country;
		this.power = power;
	}
	
	public ChargePoint() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Integer getConnections() {
		return connections;
	}
	public void setConnections(Integer connections) {
		this.connections = connections;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	
}
