package com.simple.springSecurity.repository;

import com.simple.springSecurity.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByUsername(String username);
}
