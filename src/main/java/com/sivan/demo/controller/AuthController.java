package com.sivan.demo.controller;

import com.sivan.demo.dto.UserDto;
import com.sivan.demo.entity.User;
import com.sivan.demo.repository.UserRepository;
import com.sivan.demo.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // 🔥 SIGNUP
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {

        Optional<User> existing = userRepository.findByEmail(user.getEmail());

        if (existing.isPresent()) {
            return ResponseEntity.badRequest().body("User already exists ❌");
        }

        userRepository.save(user);

        return ResponseEntity.ok("Signup successful ✅");
    }

    // 🔥 LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto user) {

        Optional<User> existing = userRepository.findByEmail(user.getEmail());

        if (existing.isPresent() &&
                existing.get().getPassword().equals(user.getPassword())) {

            return ResponseEntity.ok("Login successful ✅");
        }

        return ResponseEntity.status(401).body("Invalid credentials ❌");
    }
}
