package com.foodhotelics.demo.DTO;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Email;

import com.foodhotelics.demo.constraints.FieldMatch;

@SuppressWarnings("deprecation")
@FieldMatch.List({
    @FieldMatch(first="password",second="confirmPassword",message="Passwords must match"),
    @FieldMatch(first="email",second="confirmEmail",message="Emails  must match")          
 })
public class UserRegistrationDTO {
    
 
   @NotEmpty 
   @Email
   private String email;
   
   
   @NotEmpty
   @Email 
   private String confirmEmail;
   
   @NotEmpty
   private String name;
   
   public String getname() {
	return name;
}

public void setname(String name) {
	this.name =name;
}

 @NotEmpty
   private String password;
   
   @NotEmpty
   private String confirmPassword;
   
   public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getConfirmEmail() {
	return confirmEmail;
}

public void setConfirmEmail(String confirmEmail) {
	this.confirmEmail = confirmEmail;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getConfirmPassword() {
	return confirmPassword;
}

public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}

public boolean isTerms() {
	return terms;
}

public void setTerms(boolean terms) {
	this.terms = terms;
}

@AssertTrue
   private boolean terms;
   
 
 
 
 
 
}
