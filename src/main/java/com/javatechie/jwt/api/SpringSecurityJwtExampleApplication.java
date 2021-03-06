package com.javatechie.jwt.api;

import com.javatechie.jwt.api.entity.User;
import com.javatechie.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {
    @Autowired
    private UserRepository repository;

//    @PostConstruct
//    public void initUsers() {
//        List<User> users = Stream.of(
//                new User(1L, "javatechie", "password", "javatechie@gmail.com"),
//                new User(102L, "user1", "pwd1", "user1@gmail.com"),
//                new User(103L, "user2", "pwd2", "user2@gmail.com"),
//                new User(104L, "user3", "pwd3", "user3@gmail.com")
//        ).collect(Collectors.toList());
//        repository.saveAll(users);
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
    }

}
