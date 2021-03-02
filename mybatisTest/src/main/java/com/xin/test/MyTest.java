package com.xin.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.xin.beans.User;
import com.xin.dao.UserMapper;
import com.xin.util.MybatisUtils;

public class MyTest {

	@Test
	public void selectTest() {
		SqlSession sqlSession = MybatisUtils.getSession();
		
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> users = mapper.getAllUsers();
		
		for (User user : users) {
			System.out.println(user);
		}
		
		sqlSession.close();
	}
	
	@Test
	public void selectById() {
		SqlSession session = MybatisUtils.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
//		User user = mapper.getUserById(2+"1");
		User user = mapper.getUserByParam(9, "艾新");
		String s = "%' and bigdescription like '阳城";
		System.out.println(user);
		session.close();
	}
	
	@Test
	public void test1() {
		String s = "1";
		Boolean b = true;
		int a = 2;
		change(s, b, a);
		System.out.println("s:"+s);
		System.out.println("a:"+a);
		System.out.println("b:"+b);
	}
	
	public void change(String s,Boolean b,int a) {
		s = s + "123";
		b = !b;
		a = a+1;
		System.out.println("s1:"+s);
		System.out.println("a1:"+a);
		System.out.println("b1:"+b);
	}
	
	@Test
	public void createTest() {
		
		SqlSession session = MybatisUtils.getSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setId(4);
		user.setName("哈哈");
		user.setPwd("666sss");
		mapper.create(user);
		session.commit();
		
		session.close();
		
	}
	
	@Test
	public void updateTest() {
		
		SqlSession session = MybatisUtils.getSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> users = mapper.getAllUsers();
		User user = new User();
		System.out.println("==============update前================");
		for (User user1 : users) {
			System.out.println(user1);
			if(user1.getId() == 1) {
				user = user1;
			}
		}
		user.setPwd("aaabbb");
		mapper.update(user);
		session.commit();
		users = mapper.getAllUsers();
		System.out.println("==============update后================");
		for (User user1 : users) {
			System.out.println(user1);
		}
		
		session.close();
		
	}
	
	@Test
	public void deleteTest() {
		SqlSession session = MybatisUtils.getSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> users = mapper.getAllUsers();
		System.out.println("==============delete前================");
		for (User user1 : users) {
			System.out.println(user1);
		}
		mapper.deleteById(4);
		session.commit();
		users = mapper.getAllUsers();
		System.out.println("==============delete后================");
		for (User user1 : users) {
			System.out.println(user1);
		}
		
		session.close();
	}
	
}
