package com.san.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.model.Flight;
import com.san.service.FlightService;

@RestController
@RequestMapping("flight")
@CrossOrigin
public class FlightController {

	@Autowired
	private FlightService flightService;

	@GetMapping("/getall")
	public List<Flight> getAll() {
		return flightService.getAll();
	}

	@GetMapping("/getall/{id}")
	public Flight getById(@PathVariable Integer id) {
		return flightService.getById(id);
	}

	@PostMapping("/save")
	public Flight save(@RequestBody Flight f) {
		return flightService.save(f);
	}

	@PutMapping("/update")
	public Flight update(@RequestBody Flight f) {
		return flightService.save(f);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(Integer id) {
		return flightService.deleteById(id);
	}

}
