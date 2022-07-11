package com.itransition.appusercollection.service;

import com.itransition.appusercollection.entity.Role;
import com.itransition.appusercollection.entity.User;
import com.itransition.appusercollection.payload.RegisterDto;
import com.itransition.appusercollection.payload.response.ApiResponse;
import com.itransition.appusercollection.repository.RoleRepo;
import com.itransition.appusercollection.repository.UserRepo;
import com.itransition.appusercollection.utils.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.itransition.appusercollection.utils.AppConstants.*;


@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final UserRepo userRepository;

    private final RoleRepo roleRepository;

    private final PasswordEncoder passwordEncoder;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }


    public ApiResponse register(RegisterDto registerDto){
        if( !registerDto.getPassword().equals(registerDto.getPasswordConfirm()) ){
            return new ApiResponse("Passwords does not match", false);
        }

        if(userRepository.existsByUsername(registerDto.getUsername())){
            return new ApiResponse("Username already exists", false);
        }
        User user = new User(
                registerDto.getUsername(),
                registerDto.getEmail(),
                passwordEncoder.encode(registerDto.getPassword()),
                roleRepository.findByName(USER),
                true
        );
        userRepository.save(user);
        return new ApiResponse("User saved successfully", true, user);
    }


}
