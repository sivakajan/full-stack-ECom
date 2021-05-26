package com.example.demo.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.model.product;
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<product, Integer> {

	List<product> findByName(String id);

	
	@Query("FROM product WHERE cata_id = ?1")
	List<product> finByCatagoryId(int cata_id);

	

	


	





	
	

	
}
