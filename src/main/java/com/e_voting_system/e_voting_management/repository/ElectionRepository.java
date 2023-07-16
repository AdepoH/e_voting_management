package com.e_voting_system.e_voting_management.repository;

import org.springframework.data.repository.CrudRepository;

import com.e_voting_system.e_voting_management.models.Election;

public interface ElectionRepository extends CrudRepository<Election, Integer>{

    Election findElectionByName(String name);
    
}
