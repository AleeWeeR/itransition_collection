package com.itransition.appusercollection.repository;

import com.itransition.appusercollection.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {

    boolean existsByName(String name);


    Role findByName(String name);




}
