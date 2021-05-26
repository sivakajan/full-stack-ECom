package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.cart;

public interface CartRepo extends JpaRepository<cart, Integer> {

	List<cart> findByUsername(String name);
	@Query("FROM cart WHERE username = ?1 and car_id = ?2")
	cart findByUsernameAndCarId(String username, int id);

	



}
