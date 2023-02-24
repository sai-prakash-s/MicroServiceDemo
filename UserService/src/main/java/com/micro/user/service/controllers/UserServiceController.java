package com.micro.user.service.controllers;

import com.micro.user.service.entities.User;
import com.micro.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserServiceController {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceController.class);

    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "userRatingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User user1 = userService.getUserById(userId);
        return ResponseEntity.ok(user1);
    }

    /**
     *
     * Fallback method for circuit breaker
     */
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception exception) {
        logger.info("Executing Fallback method as one of the service seems to be down " + exception.getMessage());
        User user = User.builder()
                .age(12)
                .userId("1234")
                .userName("Dummy User")
                .emailAddress("Dummy@info.com")
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
