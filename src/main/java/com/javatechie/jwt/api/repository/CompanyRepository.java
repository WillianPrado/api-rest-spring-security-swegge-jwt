package com.javatechie.jwt.api.repository;

import com.javatechie.jwt.api.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByNameContaining(String name);
}
