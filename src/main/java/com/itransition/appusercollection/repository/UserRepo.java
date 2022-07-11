package com.itransition.appusercollection.repository;

import com.itransition.appusercollection.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Long> {

    boolean existsByEmailAndUsername(String email, String username);

    boolean existsByUsername(String username);

    Optional<User> findByEmailAndUsername(String email, String username);

    Optional<User> findByUsername(String username);
}
