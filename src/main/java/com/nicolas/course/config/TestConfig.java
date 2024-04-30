package com.nicolas.course.config;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nicolas.course.entities.Category;
import com.nicolas.course.entities.Order;
import com.nicolas.course.entities.User;
import com.nicolas.course.entities.enums.OrderStatus;
import com.nicolas.course.repositories.CategoryRepository;
import com.nicolas.course.repositories.OrderRepository;
import com.nicolas.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        User u1 = new User(null, "Nicolas", "nicolas@email.com", "11888888888",
                "nicolasnicolas");
        User u2 = new User(null, "Rodson", "rodson@email.com", "11999999999",
                "rodsonrodson");
        Order o1 = new Order(null, Instant.parse("2024-02-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2024-03-19T19:53:07Z"), u1, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2024-01-20T19:53:07Z"), u2, OrderStatus.WAITING_PAYMENT);

        userRepository.saveAll(List.of(u1, u2));
        orderRepository.saveAll(List.of(o1, o2, o3));
        categoryRepository.saveAll(List.of(cat1, cat2, cat3));
    }
}
