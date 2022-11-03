package com.example.DemoCurrent.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoCurrent.dto.UserDto;
//import com.example.DemoCurrent.entity.User;
import com.example.DemoCurrent.service.user.UserService;

@RestController
//@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserDto> createNewUser(@RequestBody UserDto dto) {
		return ResponseEntity.ok(userService.save(dto));
	}	

	@GetMapping
	public ResponseEntity<Iterable<UserDto>> getAllCategory() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getCategory(@PathVariable Integer id) {
		Optional<UserDto> categoryOptional = userService.findById(id);
		return categoryOptional.map(category -> new ResponseEntity<>(category, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody UserDto dto) {
		Optional<UserDto> userOptional = userService.findById(id);
		return userOptional.map(user1 -> {
			dto.setId(user1.getId());
			return new ResponseEntity<>(userService.save(dto), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.OK));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable Integer id){
		Optional<UserDto> userOptional = userService.findById(id);
		return userOptional.map(user -> {
			userService.remove(id);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
