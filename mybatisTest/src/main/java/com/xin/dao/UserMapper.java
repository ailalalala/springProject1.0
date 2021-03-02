package com.xin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xin.beans.User;

public interface UserMapper {

	List<User> getAllUsers();
	
	User	 getUserById(int id);
	
	//如果多个参数则必须添加参数注解
	User getUserByParam(@Param("id") int id,@Param("name")String name);
	
	//增
	int create(User user);
	
	//改
	int update(User user);
	
	//删
	int deleteById(int id);
	
}
