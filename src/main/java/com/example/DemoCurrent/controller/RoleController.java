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

import com.example.DemoCurrent.entity.Role;
import com.example.DemoCurrent.service.role.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@PostMapping
	public ResponseEntity<Role> createNewRole(@RequestBody Role role){
		return ResponseEntity.ok(roleService.save(role));
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Role>> getAll() {
		return new ResponseEntity<>(roleService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Role> getRoleId(@PathVariable Integer id){
		Optional<Role> roleOptional = roleService.findById(id);
		return roleOptional.map(category -> new ResponseEntity<>(category, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/id")
	public ResponseEntity<Role> updateRole(@PathVariable Integer id,@RequestBody Role role){
		Optional<Role> roleOptional = roleService.findById(id);
		return roleOptional.map(role1 ->{
			role.setId(role1.getId());
			return new ResponseEntity<>(roleService.save(role),HttpStatus.OK);
			}).orElseGet(()-> new ResponseEntity<>(HttpStatus.OK));
	}
	
	@DeleteMapping("/id")
	public ResponseEntity<Role> deleteRole(@PathVariable Integer id){
		Optional<Role> roleOptional = roleService.findById(id);
		return roleOptional.map(role ->{
			roleService.remove(id);
			return new ResponseEntity<>(role,HttpStatus.OK);
		}).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
