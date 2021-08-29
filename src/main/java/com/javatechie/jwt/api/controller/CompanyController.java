package com.javatechie.jwt.api.controller;

import com.javatechie.jwt.api.entity.Company;
import com.javatechie.jwt.api.entity.User;
import com.javatechie.jwt.api.exception.CompanyNotFoundException;
import com.javatechie.jwt.api.exception.UserNotableException;
import com.javatechie.jwt.api.repository.CompanyRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "*")
@Api(value="API REST Company")
public class CompanyController {

    private final CompanyRepository repository;

    @ApiOperation(value="Return a list of Company")
    @GetMapping("/listAll")
    public ResponseEntity<List<Company>> listAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @ApiOperation(value="Register a Company")
    @PostMapping("/register")
    public ResponseEntity<Company> register(@RequestBody Company company) {
        return ResponseEntity.ok(repository.save(company));
    }

    @ApiOperation(value="Find a Company By id")
    @GetMapping("/{id}")
    public Company findCompnay(@PathVariable Long id) throws CompanyNotFoundException {
        Company user = repository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
        return user;
    }

    @ApiOperation(value="Find a Company By name")
    @GetMapping("/name/{name}")
    public List<Company> findByName(@PathVariable String name)  {
        List<Company> company = repository.findByNameContaining(name);
        return company;
    }

    @PutMapping("/update")
    public ResponseEntity<Company> update(@RequestBody Company company) throws UserNotableException {
        return ResponseEntity.ok(repository.save(company));
    }


}


