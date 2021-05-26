package com.example.demo.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.ProductRepo;
import com.example.demo.Repository.cataREpo;
import com.example.demo.model.catagory;
import com.example.demo.model.product;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class ProductController {
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	cataREpo catarepo;
	
	@GetMapping(value = "/hi")
	public String get() {
		return "hi kaja";
	}
	
	@PostMapping(value = "/save")
	public product saved(@RequestBody product pro)
	{
		return productRepo.save(pro);
	}
	
	@GetMapping(value = "/getall")
	public List<product> gertall(){
//		return null;
		return productRepo.findAll(Sort.by(Sort.Direction.ASC, "price"));
	
	}
	
	@PutMapping(value = "{id}/ass/{proid}")
	public product asss(@PathVariable int id,@PathVariable int proid) {
		catagory cata=catarepo.findById(id).get();
		product pro=productRepo.findById(proid).get();
		
		pro.setCatogerys(cata);
		return productRepo.save(pro);
	}
	
	@PostMapping(value = "/desave/{id}")
	public product desave(@RequestBody product pro,@PathVariable int id) {
		
		catagory cata=catarepo.findById(id).get();
		pro.setCatogerys(cata);
		return productRepo.save(pro);
	}
	
	@GetMapping(value = "/get/{id}")
	public product cat(@PathVariable int id) {
		return	productRepo.findById(id).get();
		 
		
	}
	
	@GetMapping(value = "/catapro/{id}")
	public List<product> getcata(@PathVariable  int id){
		
		
		return productRepo.finByCatagoryId(id);
 
		
		
		
		 
	}
}
