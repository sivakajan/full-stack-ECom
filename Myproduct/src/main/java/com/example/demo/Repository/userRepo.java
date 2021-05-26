package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.user;

public interface userRepo extends JpaRepository<user, Integer> {

	user findByName(String name);

	user findByNameAndPassword(String name, String password);

}
