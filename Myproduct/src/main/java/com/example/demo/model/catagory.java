package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class catagory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "catogerys")
	private Set<product> products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<product> getProducts() {
		return products;
	}

	public void setProducts(Set<product> products) {
		this.products = products;
	}

	public catagory() {
		super();
	}

	public catagory(int id, String name, Set<product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}

	
	
}
