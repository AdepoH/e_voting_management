package com.e_voting_system.e_voting_management.controller;

import com.e_voting_system.e_voting_management.models.Voter;
import com.e_voting_system.e_voting_management.repository.CandidateRepository;
import com.e_voting_system.e_voting_management.repository.PartyRepository;
import com.e_voting_system.e_voting_management.repository.UserRepository;
import com.e_voting_system.e_voting_management.repository.VoterRepository;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class VoterController {
    final VoterRepository voterRepository;
    final CandidateRepository candidateRepository;

    final PartyRepository partyRepository;

    final UserRepository userRepository;


    public VoterController(VoterRepository voterRepository, CandidateRepository candidateRepository, PartyRepository partyRepository, UserRepository userRepository) {
        this.voterRepository = voterRepository;
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/voter/list", method = RequestMethod.GET)
    public String election(Model model){
        model.addAttribute("voters", voterRepository.findAll());
        model.addAttribute("allVoters", voterRepository.count());
        return "voter/list";
    }

    @RequestMapping(value = "voter/create", method = RequestMethod.GET)
    public String create(Model model){return "voter/list";
    }

    @RequestMapping(value = "voter/add", method = RequestMethod.GET)
    public String add(Model model, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String partyName,
                      @RequestParam String gender, @RequestParam String dob, @RequestParam String nin, @RequestParam String message,
                      @RequestParam String userId, @RequestParam boolean hasSubmitted, @RequestParam boolean isVerified){

        Voter voter = new Voter(firstName,lastName,partyName,gender,dob,nin,message,userId,hasSubmitted,isVerified);
        voterRepository.save(voter);

        return "redirect:/voter/list";
    }


}