package com.example.UserService.service;

import com.example.UserService.domain.AppUser;
import com.example.UserService.domain.AppUserRole;

import java.util.List;



public interface AppUserService {
    AppUser saveUser(AppUser appUser);
    AppUserRole saveRole(AppUserRole appUserRole);

    static String addRoleToUser(String roleName, String name) {
        return roleName;
    }

    AppUser getUser(String username);
    List<AppUser> getUsers();
    }

