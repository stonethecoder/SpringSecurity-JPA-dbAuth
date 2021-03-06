package com.stone.security.api.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
	
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	private int user_id;
	private String username;
	private String password;
	private String email;
	@OneToMany(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinTable(name="user_roles",
					joinColumns= @JoinColumn(referencedColumnName= "user_id"), 
					inverseJoinColumns= @JoinColumn(referencedColumnName="role_id"))
	private Set<Roles> roles;
	
	
	
		

}
