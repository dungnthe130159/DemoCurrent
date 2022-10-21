package com.example.DemoCurrent.service;

import java.util.List;

import com.example.DemoCurrent.entity.UserEntity;

public interface UserService {
	List<UserEntity> getAll();
	String addAndUpdate(UserEntity user);
	String remove(Integer id);
}
