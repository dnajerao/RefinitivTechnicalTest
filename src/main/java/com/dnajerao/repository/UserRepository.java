package com.dnajerao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnajerao.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
