package com.itransition.appusercollection.component;

import com.itransition.appusercollection.entity.Role;
import com.itransition.appusercollection.entity.User;
import com.itransition.appusercollection.entity.enums.Permission;
import com.itransition.appusercollection.repository.RoleRepo;
import com.itransition.appusercollection.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.itransition.appusercollection.entity.enums.Permission.*;
import static com.itransition.appusercollection.utils.AppConstants.*;

@Component
@RequiredArgsConstructor
public class AppInitialRunner implements CommandLineRunner {


    private final PasswordEncoder passwordEncoder;

    private final UserRepo userRepository;

    private final RoleRepo roleRepository;

    @Value("${spring.sql.init.mode}")
    String initMode;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("RUN BOLDI");

        if (initMode.equals("always")) {
            initData();
        }


    }




    private void initData() {
        Permission[] permissions = values();

        roleRepository.saveAll(Arrays.asList(
                //1-admin role
                new Role(1L, ADMIN, Arrays.asList(permissions)),
                //2-user role
                new Role(2L,USER, Arrays.asList(
                        ADD_COMMENT,
                        ADD_COLLECTION,
                        ADD_ITEM,
                        ADD_LIKE
                )),
                //3-guest role
                new Role(3L,GUEST, Arrays.asList(
                    VIEW_ALL_COLLECTIONS,
                    VIEW_ALL_ITEMS,
                    VIEW_ALL_LIKES,
                    VIEW_ALL_COMMENTS
                ))

        ));

        userRepository.saveAll(
                Arrays.asList(
                        new User(
                                "Adminovich Admin",
                                "admin2002@gmail.com",
                                passwordEncoder.encode( "admin123"),
                                roleRepository.findByName(ADMIN),
                                true),
                        new User(
                                "Userovich User",
                                "user2002@gmail.com",
                                passwordEncoder.encode( "user123"),
                                roleRepository.findByName(USER),
                                true))
        );

    }
}



