package com.example.UserService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AppUser")
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String username;
    private String name;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppUserRole> roles= new ArrayList<>();

}
