package com.denisa.smart_expense_tracker.service;

import com.denisa.smart_expense_tracker.dto.CreateUserRequest;
import com.denisa.smart_expense_tracker.model.User;
import com.denisa.smart_expense_tracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(CreateUserRequest request){
        User user = User.builder().name(request.getName()).email(request.getEmail()).build();

        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
}
