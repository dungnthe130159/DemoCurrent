package com.example.DemoCurrent.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.DemoCurrent.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
@Table(name = "user")
@Getter
@Setter
public class UserEntity {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String username;
	private String email;
	private String password;
	private String fullname;
	private String address;
	private int age;
	private String sex;
	private String role; // tạo 1 bảng role gồm ADMIN, USER,...(PHẦN QUYỀN) => ĐĂNG NHẬP 1. TẠO EMUN, 2 TẠO BẢNG ROLE
	private String part = Part.USER.toString();
	
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "users_role",
//			joinColumns = {@JoinColumn(name="user_id")},
//			inverseJoinColumns = {@JoinColumn(name="role_id")})

	public UserDto toDto() {
		return UserDto.builder()
				.id(this.id)
				.name(this.name)
				.username(this.username)
				.email(this.email)
				.fullname(this.fullname)
				.address(this.address)
				.age(this.age)
				.sex(this.sex)
				.role(this.role)
				.part(this.part)
				.build();
	}
	
	public static UserEntity toDomain(UserDto dto) {
		return UserEntity.builder()
				.id(dto.getId())
				.name(dto.getName())
				.username(dto.getUsername())
				.email(dto.getEmail())
				.fullname(dto.getFullname())
				.address(dto.getAddress())
				.age(dto.getAge())
				.sex(dto.getSex())
				.role(dto.getRole())
				.part(dto.getPart())
				.build();
	}
}
