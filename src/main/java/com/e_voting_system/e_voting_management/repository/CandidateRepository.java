package com.e_voting_system.e_voting_management.repository;

import org.springframework.data.repository.CrudRepository;

import com.e_voting_system.e_voting_management.models.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {

    Candidate findCandidateByNin(String nin);
    Candidate findCandidateByPost(String post);
}
