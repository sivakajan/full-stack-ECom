package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.cataREpo;
import com.example.demo.model.catagory;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/apiCat")
public class catagoeryController {
		@Autowired
		cataREpo catarepo;
	
		@GetMapping(value = "/get")
		public List<catagory> getcata(){
			return catarepo.findAll();
		}
}
