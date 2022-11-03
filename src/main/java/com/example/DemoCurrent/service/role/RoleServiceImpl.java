package com.example.DemoCurrent.service.role;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DemoCurrent.entity.Part;
import com.example.DemoCurrent.entity.Role;
import com.example.DemoCurrent.reposiroty.RoleReposirtory;

@Service
public class RoleServiceImpl implements RoleService {	
	@Autowired
	private RoleReposirtory roleRepository;
	
	@Override
	public Iterable<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Optional<Role> findById(Integer id) {
		return Optional.ofNullable(roleRepository.findById(id).get());
	}

	@Override
	public Role save(Role t) {
		t.setPart(Part.USER);
		return roleRepository.save(t);
	}

	@Override
	public void remove(Integer id) {
		roleRepository.deleteById(id);
	}
}
