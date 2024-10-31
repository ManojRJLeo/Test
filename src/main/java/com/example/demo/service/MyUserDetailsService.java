package com.example.demo.service;

import com.example.demo.model.UserPrincipal;
import com.example.demo.model.Users;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = userRepo.findByUsername(username);
        if(users == null) {
            System.out.println("USER NOT FOUND");
            throw new UsernameNotFoundException("USER NOT FOUND");
        }

        return new UserPrincipal(users);
    }
}
