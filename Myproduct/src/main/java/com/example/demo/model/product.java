package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int price;
	
	@ManyToOne
	@JoinColumn(name="cataId" ,referencedColumnName = "id")
	private catagory catogerys;
	
	@JsonIgnore
	@OneToOne(mappedBy = "product")
	private cart cart;
	
		
	
	
	public cart getCart() {
		return cart;
	}
	public void setCart(cart cart) {
		this.cart = cart;
	}
	
	
	public catagory getCatogerys() {
		return catogerys;
	}
	public void setCatogerys(catagory catogerys) {
		this.catogerys = catogerys;
	}
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public product() {
		super();
	}
	public product(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	
	
}
