package com.example.laptopshop.service;

import org.springframework.stereotype.Service;

import com.example.laptopshop.domain.User;
import com.example.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public String handleHello(){
        return "hello from service" ;
    }
    public User handleSaveUser(User user){
        User newUser = this.userRepository.save(user);
        System.out.println(newUser);
        return newUser ;
        
    }
}
