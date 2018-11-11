package com.stone.security.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Roles {
	
	@Id
	@GenericGenerator(name="gen",strategy= "increment")
	@GeneratedValue(generator="gen")
	private int role_id;
	private String role;

}
