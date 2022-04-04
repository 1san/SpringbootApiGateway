package com.san.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.model.Flight;
import com.san.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepo;

	public List<Flight> getAll() {
		return flightRepo.findAll();
	}

	public Flight getById(Integer id) {
		return flightRepo.findById(id).get();
	}

	public Flight save(Flight f) {
		return flightRepo.save(f);
	}

	public String deleteById(Integer id) {
		flightRepo.deleteById(id);
		return "Flight record succesfully deleted";
	}

}
