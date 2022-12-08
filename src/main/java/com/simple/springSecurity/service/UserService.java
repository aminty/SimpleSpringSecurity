package com.simple.springSecurity.service;

import com.simple.springSecurity.domain.SecurityUser;
import com.simple.springSecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(foundUser->new SecurityUser(foundUser))
                .orElseThrow(()-> new UsernameNotFoundException("username not found : ("+username+")"));
    }
}
