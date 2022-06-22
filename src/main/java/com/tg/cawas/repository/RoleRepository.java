package com.tg.cawas.repository;

import com.tg.cawas.entity.Role;
import com.tg.cawas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
