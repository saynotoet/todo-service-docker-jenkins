package com.todo.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.service.model.User;
 

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
