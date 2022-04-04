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

import com.san.model.UserProfile;
import com.san.service.UserProfileService;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserProfileService service;

	@GetMapping("/getall")
	public List<UserProfile> getAll() {
		return service.getAll();
	}

	@GetMapping("/getall/{id}")
	public UserProfile getById(@PathVariable Integer id) {
		return service.getById(id);
	}

	@PostMapping("/save")
	public UserProfile save(@RequestBody UserProfile u) {
		return service.save(u);
	}

	@PutMapping("/update")
	public UserProfile update(@RequestBody UserProfile u) {
		return service.save(u);
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		return service.deleteById(id);

	}

}
