package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.demo.models.ChargePoint;
import com.example.demo.models.ResponseOptions;
import com.example.demo.repository.ChargePointRepository;

@Service
public class ChargePointService implements ChargePointRepository{
	
	private static final String OPERATIONAL_STATUS = "Operational";

	@Autowired
	private ChargePointRepository chargePointRepository;
	
	public ResponseOptions findBestOption(String lat, String lon){
		List<ChargePoint> listCp = chargePointRepository.findAll();
		ResponseOptions response = new ResponseOptions();
		if(listCp.isEmpty()) return null;
		
		response.setChargePointBestDistance(findBestDistance(lat, lon, listCp));
		
		response.setChargePointBestPower(findBestPower(lat, lon, listCp));   
		return response;
	}
	
	private ChargePoint findBestPower(String lat, String lon, List<ChargePoint> listCp) {
		int maxPower = 0;
		ChargePoint bestPowerPoint = listCp.get(0);
		for(int i = 1 ; i<listCp.size() ; i++) {
			if(listCp.get(i).getPower() > maxPower && listCp.get(i).getStatus().equals(OPERATIONAL_STATUS)) {
				maxPower = listCp.get(i).getPower();
				bestPowerPoint = listCp.get(i);
			}
		}
		if(!bestPowerPoint.getStatus().equals(OPERATIONAL_STATUS)) return null;
		
		return bestPowerPoint;
		
	}

	private ChargePoint findBestDistance(String lat, String lon, List<ChargePoint> listCp) {
		ChargePoint bestOption = listCp.get(0);
		double ac = Math.abs( Double.valueOf(lon) - Double.valueOf(listCp.get(0).getLatitude()));
	    double cb = Math.abs(Double.valueOf(lat) - Double.valueOf(listCp.get(0).getLongitude()));
	    double bestDistance =  Math.hypot(ac, cb);
	    double distance =0;
	    for(int i = 1; i < listCp.size() ; i++ ) {
	    	ac = Math.abs( Double.valueOf(lon) - Double.valueOf(listCp.get(i).getLatitude()));
		    cb = Math.abs(Double.valueOf(lat) - Double.valueOf(listCp.get(i).getLongitude()));
		    distance =  Math.hypot(ac, cb);
		    if(distance < bestDistance) {
		    	bestDistance = distance;
		    	bestOption = listCp.get(i);
		    }
	    }
	    return bestOption;
	}



	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends ChargePoint> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ChargePoint> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<ChargePoint> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChargePoint getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChargePoint getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChargePoint getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ChargePoint> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ChargePoint> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ChargePoint> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChargePoint> findAll() {
		return chargePointRepository.findAll();
	}

	@Override
	public List<ChargePoint> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ChargePoint> S save(S entity) {
		return chargePointRepository.save(entity);
	}

	@Override
	public Optional<ChargePoint> findById(Long id) {
		return chargePointRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ChargePoint entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends ChargePoint> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ChargePoint> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ChargePoint> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ChargePoint> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends ChargePoint> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ChargePoint> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends ChargePoint> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends ChargePoint, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
