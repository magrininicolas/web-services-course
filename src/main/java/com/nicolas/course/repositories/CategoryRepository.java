package com.nicolas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
