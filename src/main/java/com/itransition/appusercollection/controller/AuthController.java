package com.itransition.appusercollection.controller;


import com.itransition.appusercollection.entity.Role;
import com.itransition.appusercollection.entity.User;
import com.itransition.appusercollection.entity.enums.Permission;
import com.itransition.appusercollection.payload.LoginDto;
import com.itransition.appusercollection.payload.RegisterDto;
import com.itransition.appusercollection.payload.response.ApiResponse;
import com.itransition.appusercollection.repository.UserRepo;
import com.itransition.appusercollection.service.AuthService;
import com.itransition.appusercollection.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


@Controller
@RequestMapping("/")
public class AuthController {
    @Autowired
    AuthService authService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;



    @GetMapping
    public String getHomePage(){

        return "index";

    }

    @GetMapping("sign-in")
    public String getSigninPage(Model model){
        model.addAttribute("logging", new LoginDto());

        return "sign-in";
    }

    @PostMapping("sign-in")
    public String signIn(@RequestBody RegisterDto registerDto, Model model){

        return "redirect:/";
    }

    @GetMapping("sign-up")
    public String getSignUpPage(Model model){
        model.addAttribute("registering", new RegisterDto());


        return "sign-up";
    }

    @PostMapping("sign-up")
    public String singUp(@ModelAttribute RegisterDto registerDto, Model model){
        ApiResponse registerResponse = authService.register(registerDto);
        if (!registerResponse.isSuccess()){
            model.addAttribute("error", "Existed username");
            return "sign-in";
        }
        User mappedUser = modelMapper.map(registerDto, User.class);
        mappedUser.setRole(new Role("USER", Arrays.asList(Permission.DELETE_USER, Permission.ADD_USER)));
        userService.saveUser(mappedUser);
        model.addAttribute("userRegistered", new User());
        return "redirect:/index";
    }

}
