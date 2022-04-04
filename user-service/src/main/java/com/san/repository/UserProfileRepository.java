package com.san.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.san.model.UserProfile;

@Repository
@Transactional
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

}
