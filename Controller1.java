package com.foodhotelics.demo.controllers;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 {
	 	//@RequestMapping("/")
	//public ModelAndView home(){
	//	String welcomeMessage = new String("Welcome to Food Hotelics");
	//	return new ModelAndView("index","Model1",welcomeMessage);
	//}
	
	
	@GetMapping("/")
	public String test(){
	
		return "test";
	}
	
	
	@GetMapping("/login")
	public String login(Model model){
	    
		return "Login";
	}

	@RequestMapping(value="/userWelcome")
	public ModelAndView userwelcome(){
		String username=" ";
		Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails ){
			username = ((UserDetails)principal).getUsername(); 
		}
		String welcomeMessage = new String("Welcome to Food Hotelics"+" "+username+"!");
		
		return new ModelAndView("userWelcome","Model1",welcomeMessage);
	}
	@RequestMapping(value="/adminWelcome",method=RequestMethod.POST )
	public ModelAndView adminwelcome(){
		String welcomeMessage = new String("Welcome to Food Hotelics Admin Page");
		
		return new ModelAndView("adminWelcome","Model2",welcomeMessage);
	}
	@RequestMapping(value="/403")
	public ModelAndView error403(){
		
		return new ModelAndView("/error/403");
	}
}
