package com.e_voting_system.e_voting_management.repository;

import org.springframework.data.repository.CrudRepository;

import com.e_voting_system.e_voting_management.models.Party;

public interface PartyRepository extends CrudRepository<Party, Long>{

    Party findPartyByName(String partyName);
}
