package com.e_voting_system.e_voting_management.repository;

import org.springframework.data.repository.CrudRepository;

import com.e_voting_system.e_voting_management.models.Voter;

public interface VoterRepository extends CrudRepository<Voter, Integer> {

    Voter findVoterByFirstName(String firstName);
    Voter findVoterById(String id);
    
}
