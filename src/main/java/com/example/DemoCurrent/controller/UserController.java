package com.example.DemoCurrent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoCurrent.entity.UserEntity;
import com.example.DemoCurrent.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserEntity>> getAll(){
		return ResponseEntity.ok(this.userService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody UserEntity user) {
		return ResponseEntity.ok(this.userService.addAndUpdate(user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(this.userService.remove(id));
	}
}
