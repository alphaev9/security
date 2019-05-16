package com.alpha.security.authorize.service;


import com.alpha.security.authorize.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{

	static List<User> users = new ArrayList<User>();
	
	static{
		users = populateUser();
	}
	
	@Override
	public List<User> findAllUsers(){
		return users;
	}
	
	@Override
	public User findById(int id){
		for(User u : users){
			if(u.getId()==id){
				return u;
			}
		}
		return null;
	}
	
	@Override
	public void updateUser(User user) {
		System.out.println("Only an Admin can Update a User");
		User u = findById(user.getId());
		users.remove(u);
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setType(user.getType());
		users.add(u);
	}
	
	@Override
	public void deleteUser(int id){
		User u = findById(id);
		users.remove(u);
	}
	
	private static List<User> populateUser(){
		List<User> users = new ArrayList<User>();
		users.add(new User(1,"Sam","Disilva","admin"));
		users.add(new User(2,"Kevin","Brayn","admin"));
		users.add(new User(3,"Nina","Conor","dba"));
		users.add(new User(4,"Tito","Menz","dba"));
		return users;
	}

}
