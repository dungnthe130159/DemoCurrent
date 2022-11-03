package com.example.DemoCurrent.entity;

import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "role")
@Getter
@Setter
public class Role {
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private String role;
	private Part part;
	
}
