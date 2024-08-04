package dev.nikhil.gokapture.controller;

import dev.nikhil.gokapture.dto.UserDTO;
import dev.nikhil.gokapture.dto.TaskDTO;
import dev.nikhil.gokapture.model.User;
import dev.nikhil.gokapture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    TaskDTO taskDTO;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserDTO userDTO) {
        User user = userService.findByUsername(userDTO.getUsername());
        if (user != null && user.getPassword().equals(userDTO.getPassword())) {
            // Generate JWT token
        }
        throw new RuntimeException("Invalid credentials");
    }
}
