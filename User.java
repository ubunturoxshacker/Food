package com.foodhotelics.demo.model;

import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name="users",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User  
{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private Long id;
  
  @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.ALL})
  @JoinTable(
          name = "user_roles",
          joinColumns = @JoinColumn(
                  name = "user_id"),
          inverseJoinColumns = @JoinColumn(
                  name = "role_id"))
  private Collection<Role> role;

  private String name;
 
  private String password;

  private String email;
 
 @Override
 public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", password='" + "*********" + '\'' +
            ", role=" + role +
            '}';
  }

   public User(){
	   
   }

   public User(Long id, Collection<Role> role, String name, String password, String email) {
	super();
	this.id = id;
	this.role = role;
	this.name = name;
	this.password = password;
	this.email = email;
	
   }
   public User(Long id, String name, String password, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		
	}
   public Long getId() {
	return id;
   }

   public void setId(Long id) {
	this.id = id;
   }


    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
   
   public String getEmail() {
	return email;
   }
   public void setEmail(String email) {
		this.email = email;
	}
   
   public String getname() {
		 return name;
	   }
   public void setname(String name) {
	     this.name =name;
	  }
  
     public Collection<Role> getRole() {
	   return role;
     }
    public void setRole(Collection<Role> role) {
	  this.role = role;
    }
}
