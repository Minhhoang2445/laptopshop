package com.example.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.laptopshop.domain.User;
import com.example.laptopshop.repository.UserRepository;
import com.example.laptopshop.service.UserService;
import org.springframework.ui.Model; 
@Controller
public class UserController{
    private final UserService userService;

    public UserController(UserService userService) {
    this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("message", "Hello from Laptop Shop!");
        return "hi";
    }
    
    @RequestMapping("/admin/user") // if dont set up, it is GET by default
    public String getUserPage(Model model) {
        model.addAttribute("newUser", "test"); 
        return "admin/user/create";
    }
    
    @RequestMapping(value= "/admin/user/create", method = RequestMethod.POST) 
    public String createUserPage(Model model, @ModelAttribute("newUser") User newUser) {
        System.out.println("create user" + newUser);
        this.userService.handleSaveUser(newUser);
        return "hi";
    }

}

