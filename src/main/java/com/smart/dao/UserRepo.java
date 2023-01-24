package com.smart.dao;


import org.springframework.data.repository.CrudRepository;


import com.smart.entities.User;

public interface UserRepo extends CrudRepository<User,Integer> 
{
	

}
