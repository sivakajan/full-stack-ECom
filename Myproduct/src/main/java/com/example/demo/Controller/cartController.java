package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.CartRepo;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.model.cart;
import com.example.demo.model.catagory;
import com.example.demo.model.product;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/apicart")
@RestController
public class cartController {
	
	@Autowired 
	CartRepo cartrepo;
	
	@Autowired
	ProductRepo prorepo;
	
	@PostMapping(value = "/savecart")
	public cart setcarttouser(@RequestBody cart carts)
	{
		return cartrepo.save(carts);
	}
	
	@GetMapping(value = "/one")
	public List<cart> getone() {
		return cartrepo.findAll();
	}
	
	
	@PostMapping(value = "/desave/{id}")
	public cart desave(@RequestBody cart car,@PathVariable int id) throws Exception {
		cart carts=cartrepo.findByUsernameAndCarId(car.getUsername(), id);
		if(carts!=null)
		{
			throw new Exception("user withalready exit");
		}
		product products=prorepo.findById(id).get();
		
		car.setProduct(products);
		
		return cartrepo.save(car);
	}
	
	@GetMapping(value = "/oneman")
	public List<cart> getoneman(@RequestParam  String  username) {
		return cartrepo.findByUsername(username);
	}
	
	@DeleteMapping(value = "/deleteone/{id}")
	public String deleteone(@PathVariable int  id) {
		cartrepo.deleteById(id);
		return "deleted";
	}
	
	@GetMapping(value = "/getone/{name}")
	public ResponseEntity<Integer> getListCart(@PathVariable String name){
		int x=cartrepo.findByUsername(name).size();
		return new ResponseEntity<>(x,HttpStatus.OK);
	}
	
	@GetMapping(value = "/two")
	public int hh() {
		return 2;
	}
	
	
}
