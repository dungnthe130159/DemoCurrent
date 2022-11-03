package com.example.DemoCurrent.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DemoCurrent.entity.Role;

@Repository
public interface RoleReposirtory extends JpaRepository<Role, Integer>{
}
