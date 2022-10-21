package com.example.DemoCurrent.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DemoCurrent.entity.UserEntity;
import com.example.DemoCurrent.reposiroty.UserRepository;
import com.example.DemoCurrent.service.UserService;

@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	private UserRepository repo;
	
	@Override
	public List<UserEntity> getAll() {
		return this.repo.findAll();
	}

	@Override
	public String addAndUpdate(UserEntity user) {
		this.repo.save(user);
		return "Thêm Thành Công";
	}

	@Override
	public String remove(Integer id) {
		Optional<UserEntity> user = this.repo.findById(id);
		if(user.isPresent()) {
			this.repo.delete(user.get());
			return "Xóa thành công";
		}
		return "Không tồn tại";
	}

}
