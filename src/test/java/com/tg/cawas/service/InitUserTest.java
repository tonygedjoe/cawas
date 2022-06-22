package com.tg.cawas.service;

import com.tg.cawas.entity.Meeting;
import com.tg.cawas.entity.Role;
import com.tg.cawas.entity.User;
import com.tg.cawas.repository.MeetingRepository;
import com.tg.cawas.repository.RoleRepository;
import com.tg.cawas.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class InitUserTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Test
    public void initUserTest() {

        String password = "tgpass";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encPasswd = passwordEncoder.encode(password);


        User u1 = new User();
        u1.setUsername("tony");
        u1.setPasswd(encPasswd);
        u1.setRoleSet(new HashSet<Role>(Arrays.asList( new Role("MEMBER", ""))));
        userRepository.save(u1);

        User u2 = new User();

        u2.setUsername("admin");
        u2.setPasswd(encPasswd);
        u2.setRoleSet(new HashSet<Role>(Arrays.asList( new Role("ADMIN", ""))));
        userRepository.save(u2);

        return;
    }

    @Test
    public void getUserTest() {

        User u1 = userRepository.findByUsername("tony");

        assertTrue(u1.getUsername().equals("tony"));

        assertTrue(u1.getPasswd().length() > 0);
        assertTrue(u1.getRoleSet().size() == 1);
    }
}
