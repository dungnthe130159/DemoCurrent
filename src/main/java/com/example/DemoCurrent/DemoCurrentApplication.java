package com.example.DemoCurrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.DemoCurrent.entity.Part;
import com.example.DemoCurrent.entity.UserEntity;

@SpringBootApplication
public class DemoCurrentApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoCurrentApplication.class, args);
//		String p = Part.ADMIN.toString();
//		System.out.println(p);
	}
}

