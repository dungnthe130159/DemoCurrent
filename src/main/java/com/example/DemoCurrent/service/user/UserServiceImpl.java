package com.example.DemoCurrent.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DemoCurrent.dto.UserDto;
import com.example.DemoCurrent.entity.UserEntity;
import com.example.DemoCurrent.reposiroty.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository; 
	
	@Override
	public Iterable<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserEntity::toDto)::iterator;
    }

	@Override
	public Optional<UserDto> findById(Integer id) {
		return Optional.ofNullable(userRepository.findById(id).get().toDto());
	}

	@Override
	public UserDto save(UserDto t) {
		t.setPart("USER");
		return userRepository.save(UserEntity.toDomain(t)).toDto();
	}

	@Override
	public void remove(Integer id) {
		userRepository.deleteById(id);
	}
	
}
