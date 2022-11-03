package com.example.DemoCurrent.dto;

import com.example.DemoCurrent.entity.Part;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	private int id;
	private String name;
	private String username;
	private String email;
//	private String password;
	private String fullname;
	private String address;
	private int age;
	private String sex;
	private String role;
	private String part = Part.USER.toString();
	
}
