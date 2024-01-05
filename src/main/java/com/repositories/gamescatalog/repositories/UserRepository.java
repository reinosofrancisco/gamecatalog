package com.repositories.gamescatalog.repositories;

import org.springframework.stereotype.Repository;

import com.repositories.gamescatalog.security.User;

@Repository
public class UserRepository {
    public User findUserByEmail(String email){
        User user = new User(email,"123456");
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        return user;
    }
}
