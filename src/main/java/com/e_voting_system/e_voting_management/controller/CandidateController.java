package com.e_voting_system.e_voting_management.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e_voting_system.e_voting_management.models.Candidate;
import com.e_voting_system.e_voting_management.models.Party;
import com.e_voting_system.e_voting_management.models.Post;
import com.e_voting_system.e_voting_management.repository.CandidateRepository;
import com.e_voting_system.e_voting_management.repository.PartyRepository;
import com.e_voting_system.e_voting_management.repository.PostRepository;


import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CandidateController {
    
    final CandidateRepository candidateRepository;
    final PostRepository postRepository;
    final PartyRepository partyRepository; 

    public CandidateController(CandidateRepository candidateRepository, PostRepository postRepository, PartyRepository partyRepository){
        this.candidateRepository = candidateRepository;
        this.postRepository = postRepository;
        this.partyRepository = partyRepository;
    }

    @RequestMapping(value = "/candidate/List", method = RequestMethod.GET)
    public String candidate(Model model){

        model.addAttribute("candidate",candidateRepository.findAll());
        model.addAttribute("allCandidate", candidateRepository.count());

        return "candidate/list";
    }

    
    @RequestMapping(value = "/candidate/create", method = RequestMethod.GET)
    public String create(Model model){
        return "candidate/list";
    }

    @RequestMapping(value = "/candidate/add",method = RequestMethod.POST)
    public String add(Model model, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String partyName, @RequestParam String post, @RequestParam String gender, @RequestParam String dob, @RequestParam String nin, @RequestParam String userId,
    @RequestParam boolean hasSubmitted, @RequestParam boolean isVerified){

        Post posts = postRepository.findPostByName(post);
        Party partyNames = partyRepository.findPartyByName(partyName);

        Candidate candidate = new Candidate(firstName, lastName, partyNames, posts, gender, dob, nin, userId, hasSubmitted, isVerified);
        candidateRepository.save(candidate);

        return "redirect:/candidate/list";

    }

    @RequestMapping(value = "/candidate/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") int id, Model model) {

        model.addAttribute("candidate", candidateRepository.findById(id).get());
        return "candidate/edit";
    }

    @RequestMapping(value = "/candidate/update", method = RequestMethod.POST)
    public String updateElection(Model model, @RequestParam int id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String partyName, @RequestParam String post, @RequestParam String gender, @RequestParam String dob, @RequestParam String nin) {

        Candidate candidate = candidateRepository.findById(id).get();

        Post posts = postRepository.findPostByName(post);
        Party partyNames = partyRepository.findPartyByName(partyName);

        candidate.setFirstName(firstName);
        candidate.setLastName(lastName);
        candidate.setPartyName(partyNames);
        candidate.setPost(posts);
        candidate.setGender(gender);
        candidate.setDob(dob);
        candidate.setNin(nin);

        candidateRepository.save(candidate);

        return "redirect:/candidate/list";

    }

    @RequestMapping(value = "/candidate/delete/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") int id, Model model) {

        Candidate candidate = candidateRepository.findById(id).get();

        candidateRepository.delete(candidate);

        return "redirect:/candidate/list";
    }
}
