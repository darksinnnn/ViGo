package com.ex.vigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.vigo.entities.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, String> {


}
