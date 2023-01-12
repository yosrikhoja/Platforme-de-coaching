package com.example.UserService.api;

import com.example.UserService.domain.AppUser;
import com.example.UserService.domain.AppUserRole;
import com.example.UserService.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {
    private final AppUserService appUserService;
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>>getUsers(){
        return ResponseEntity.ok().body(appUserService.getUsers());
    }


    @PostMapping("/role/save")
    public ResponseEntity<AppUserRole>saveRole(@RequestBody AppUserRole appUserRole){
    URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
    return ResponseEntity.created(uri).body(appUserService.saveRole(appUserRole));}

    @PostMapping("user/save")
    public ResponseEntity<AppUser>saveUser(@RequestBody AppUser appUser){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveUser(appUser));}

    @PostMapping("role/addToUser")
    public ResponseEntity<?>addToUser(@RequestBody RoleToUserForm role){
        AppUserService.addRoleToUser(role.getUsername(),role.getRoleName());
        return ResponseEntity.ok().build();

}
}
