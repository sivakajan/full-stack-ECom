package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.userRepo;
import com.example.demo.model.user;
import com.example.demo.service.userservice;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/apiuser")
public class UserController {
	
	@Autowired
	userRepo userrepo;
	
	@Autowired 
	userservice userser;
	
	@GetMapping(value = "/hi")
	public String hi() {
		return "hi";
	}
	
	@PostMapping(value = "/save")
	public user usersaved(@RequestBody user users) throws Exception
	{	
		String tempNameId=users.getName();
		if(tempNameId !=null && !"".equals(tempNameId)) {
			user userObj=userrepo.findByName(tempNameId);
			if(userObj !=null) {
				throw new Exception("user with"+tempNameId+"already exit");
			}
		}
		
		user userObj=null;
		userObj=userrepo.save(users);
		return userObj;
	}
	
	
	@GetMapping(value = "/getall")
	public List<user> get(){
		return userrepo.findAll();
		
	}
	
//	@GetMapping(value = "/getone/{name}/{password}")
//	public String getone(@PathVariable String name,@PathVariable String password) {
//		user userone=userrepo.findByName(name);
//		if(name.equals(userone.getName()) && password.equals(userone.getPassword())){
//			return "success";
//		}else
//		{
//			return "fails";
//		}
//		
//	}
	
	
	@PostMapping(value = "/login")
	public user login(@RequestBody user users) throws Exception {
		String tempName=users.getName();
		String temPass=users.getPassword();
		
		user userObj=null;
		if(tempName!=null && temPass!=null) {
			 userObj=userser.getNameAndPassword(tempName, temPass);
		}
		if(userObj ==null)
		{
			throw new Exception("bad credetials");
		}
		
		return userObj;
	}

}
