package com.example.UserService.repo;

import com.example.UserService.domain.AppUserRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppUserRoleRepo extends JpaRepository<AppUserRole,Long> {
     AppUserRole findByName(String name);
    AppUserRole save(String role);
}
