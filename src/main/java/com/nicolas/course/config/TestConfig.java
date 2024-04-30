package com.nicolas.course.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nicolas.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private UserRepository userRepository;

    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // User u1 = new User(null, "Nicolas", "nicolas@email.com", "11888888888",
        // "nicolasnicolas");
        // User u2 = new User(null, "Rodson", "rodson@email.com", "11999999999",
        // "rodsonrodson");

        // userRepository.saveAll(List.of(u1, u2));
    }
}
