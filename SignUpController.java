package com.foodhotelics.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.foodhotelics.demo.DTO.UserRegistrationDTO;
import com.foodhotelics.demo.model.User;
import com.foodhotelics.demo.service.UserService;

@Controller
@RequestMapping (value="/signUp")
@SessionAttributes("user")
public class SignUpController {

	@Autowired 
	private UserService userService;

	@ModelAttribute("user")
	public UserRegistrationDTO userRegistrationDTO(){
		return new UserRegistrationDTO() ;
		
	}
	
	@GetMapping
	public String showRegistrationForm(Model model){
		return "SignUp" ;
	}
	
	
	@PostMapping
	
	public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDTO userRegistrationDTO, BindingResult result){
		User existingUser = userService.findByEmail(userRegistrationDTO.getEmail());
		
		if(existingUser!=null){
			result.rejectValue("email",null,"There is already an account registered with that email");
		}
		if(result.hasErrors()){
			return "SignUp";
		}
		userService.save(userRegistrationDTO);
		return "redirect:/signUp?success";
	}
}
