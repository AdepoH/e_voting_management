package com.e_voting_system.e_voting_management.repository;

import java.util.Optional;

import com.e_voting_system.e_voting_management.models.User;

public interface UserRepository {

    Optional<User> findByUsername(String userName);
    
}
