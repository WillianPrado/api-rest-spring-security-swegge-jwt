package com.javatechie.jwt.api.repository;

import com.javatechie.jwt.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
}
