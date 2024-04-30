package com.nicolas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
