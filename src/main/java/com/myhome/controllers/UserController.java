package com.myhome.controllers;

import com.myhome.core.interfaces.UserRepository;
import com.myhome.core.models.User;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryMapping
    public Optional<User> getUserById(@Argument Long id) {
        return userRepository.findById(id);
    }

    @QueryMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email) {
        return userRepository.save(new User(name, email));
    }
}
