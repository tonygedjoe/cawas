package com.tg.cawas.repository;

import com.tg.cawas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
