package com.denisa.smart_expense_tracker.controller;

import com.denisa.smart_expense_tracker.dto.CreateUserRequest;
import com.denisa.smart_expense_tracker.model.User;
import com.denisa.smart_expense_tracker.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.CacheRequest;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@Valid @RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

}
