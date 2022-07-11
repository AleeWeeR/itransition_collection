package com.itransition.appusercollection.service;

import com.itransition.appusercollection.entity.User;
import com.itransition.appusercollection.payload.response.ApiResponse;
import com.itransition.appusercollection.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepository;

    public ApiResponse saveUser(User user){
        User saved = userRepository.save(user);
        return new ApiResponse( "User saved", true, saved);
    }
}
