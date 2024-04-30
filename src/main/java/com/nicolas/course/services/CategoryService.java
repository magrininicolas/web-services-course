package com.nicolas.course.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.nicolas.course.entities.Category;
import com.nicolas.course.repositories.CategoryRepository;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category not found with id: " + id));
    }
}
