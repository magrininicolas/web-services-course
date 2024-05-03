package com.nicolas.course.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.nicolas.course.entities.User;
import com.nicolas.course.repositories.UserRepository;

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
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user, Long id) {
        User oldUser = findById(id);
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhone(user.getPhone());
        return oldUser;
    }

    public void deleteUser(Long id) {
        userRepository.delete(findById(id));
    }
}
