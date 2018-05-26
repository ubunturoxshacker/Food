package com.foodhotelics.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Role {

 @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name="role_id")
  private Long id;

 private String name;
 
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Role(String string) {
	
	this.name=string;
}

public Role() {
	
}
@Override
public String toString() {
    return "Role{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
}





 


  
  
  
  
  
}
