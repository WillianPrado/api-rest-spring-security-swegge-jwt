package com.javatechie.jwt.api.controller;

import com.javatechie.jwt.api.entity.AuthRequest;
import com.javatechie.jwt.api.entity.User;
import com.javatechie.jwt.api.exception.UserNotFoundException;
import com.javatechie.jwt.api.exception.UserNotableException;
import com.javatechie.jwt.api.repository.UserRepository;
import com.javatechie.jwt.api.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "*")
@Api(value="API REST User")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    private final UserRepository repository;


    public UserController(UserRepository repository) {
        this.repository = repository;
    }
    @ApiOperation(value="Return Welcome!!")
    @GetMapping("/")
    public String welcome() {
        return "Welcome!!";
    }

    @ApiOperation(value="Return a list of User")
    @GetMapping("/listAll")
    public ResponseEntity<List<User>> listAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @ApiOperation(value="Return a user by id")
    @GetMapping("/{id}")
    public User findUser(@PathVariable Long id) throws UserNotFoundException {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return user;
    }

    @ApiOperation(value="Register a user.")
    @PostMapping("/register")
    public ResponseEntity<User> salvar(@RequestBody User user) {
        return ResponseEntity.ok(repository.save(user));
    }

    @ApiOperation(value="Update a user")
    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) throws UserNotableException {
        return ResponseEntity.ok(repository.save(user));
    }

    @ApiOperation(value="Authenticate a user returned a key token")
    //@PreAuthorize("hasRole('admin)")
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
