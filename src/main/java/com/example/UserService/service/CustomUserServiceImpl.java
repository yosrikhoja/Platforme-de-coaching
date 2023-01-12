package com.example.UserService.service;

import com.example.UserService.domain.AppUser;
import com.example.UserService.repo.AppUserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
@Service
@Slf4j
public class CustomUserServiceImpl implements UserDetailsService {
    @Autowired
    private AppUserRepo appUserRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findByUsername(username);
        if (appUser==null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else{
            log.info("User found in the database:{}",username);
        }
        Collection<SimpleGrantedAuthority> authorities =new ArrayList<>();
        appUser.getRoles().forEach(role ->
                authorities
                        .add(new SimpleGrantedAuthority(
                                role
                                        .getName())));
        return new org.springframework.security.core.userdetails.User(appUser.getUsername(),appUser.getPassword(),authorities);
    }
}
