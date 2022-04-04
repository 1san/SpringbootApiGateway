package com.san.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.model.UserProfile;
import com.san.repository.UserProfileRepository;

@Service
public class UserProfileService {

	@Autowired
	private UserProfileRepository repository;
	
	public List<UserProfile> getAll(){
		return repository.findAll();
	}
	
	public UserProfile getById(Integer id){
		return repository.findById(id).get();
	}
	
	public UserProfile save(UserProfile u){
		return repository.save(u);
	}
	
	public UserProfile update(UserProfile u){
		return repository.save(u);
	}
	
	public String deleteById(Integer id){
		repository.deleteById(id);
		return "1 record delete successfully";
	}

}
