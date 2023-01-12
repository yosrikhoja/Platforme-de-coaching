package com.example.UserService.repo;

import com.example.UserService.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {

    //@Query("Select u from AppUser u WHERE u.username=:username")
    AppUser findByUsername(@Param("username") String name);

}
