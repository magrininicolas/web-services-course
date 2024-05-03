package com.nicolas.course.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nicolas.course.entities.User;
import com.nicolas.course.repositories.UserRepository;
import com.nicolas.course.services.exceptions.DatabaseException;
import com.nicolas.course.services.exceptions.UserNotFoundException;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user, Long id) {
        User oldUser = findById(id);
        updateData(user, oldUser);
        return oldUser;
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found with id: " + id);
        }
        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Database error: " + e.getMessage());
        }
    }

    private void updateData(User user, User oldUser) {
        if (user != null) {
            if (isNotBlankOrNull(user.getName())) {
                oldUser.setName(user.getName());
            }
            if (isNotBlankOrNull(user.getEmail())) {
                oldUser.setEmail(user.getEmail());
            }
            if (isNotBlankOrNull(user.getPhone())) {
                oldUser.setPhone(user.getPhone());
            }
        }
    }

    private boolean isNotBlankOrNull(String str) {
        return str != null && !str.trim().isEmpty();
    }

}
