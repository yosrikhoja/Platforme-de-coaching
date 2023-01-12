package com.example.UserService.service;

import com.example.UserService.domain.AppUser;
import com.example.UserService.domain.AppUserRole;
import com.example.UserService.repo.AppUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class AppUserServiceImpl implements AppUserService  {
    private final AppUserRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("Saving new user {} to the database",appUser.getName());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepo.save(appUser);
    }

    @Override
    public AppUserRole saveRole(AppUserRole appUserRole) {
        log.info("Saving new role {} to the database",appUserRole.getName());
        return appUserRole.save(appUserRole);
    }


    @Override
    public AppUser getUser(String username) {
        log.info("Fetching user {} in our database",username);

        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all user in our database");
        return appUserRepo.findAll();
    }


}
