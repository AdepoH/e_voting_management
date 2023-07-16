package com.e_voting_system.e_voting_management.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.e_voting_system.e_voting_management.models.Candidate;
import com.e_voting_system.e_voting_management.models.Election;
import com.e_voting_system.e_voting_management.repository.CandidateRepository;
import com.e_voting_system.e_voting_management.repository.ElectionRepository;

@Controller
public class ElectionController {

    final ElectionRepository electionRepository;
    final CandidateRepository candidateRepository;

    public ElectionController(ElectionRepository electionRepository, CandidateRepository candidateRepository){
        this.electionRepository = electionRepository;
        this.candidateRepository = candidateRepository;
    }

    @RequestMapping(value = "/election/list", method = RequestMethod.GET)
    public String election(Model model){
        model.addAttribute("elections", electionRepository.findAll());
        model.addAttribute("allElections", electionRepository.count());
        return "election/list";
    }

    @RequestMapping(value = "/election/create", method = RequestMethod.GET)
    public String create(Model model){
        return "election/list";
    }

    @RequestMapping(value = "/election/add",method = RequestMethod.POST)
    public String add(Model model, @RequestParam String electionName, @RequestParam String candidate, @RequestParam String results, @RequestParam boolean isDone){

        long millis = System.currentTimeMillis();
        Date startDate = new Date(millis);
        Date endDate = new Date(millis);

        Candidate candidates = candidateRepository.findCandidateByPost(candidate);
        
        Election election = new Election(electionName, startDate, endDate, candidates, results, isDone);
        electionRepository.save(election);

        return "redirect:/election/list";

    }

    @RequestMapping(value = "/election/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") int id, Model model) {

        model.addAttribute("election", electionRepository.findById(id).get());
        return "election/edit";
    }

    @RequestMapping(value = "/election/update", method = RequestMethod.POST)
    public String updateElection(Model model, @RequestParam int id, @RequestParam String electionName) {

        Election election = electionRepository.findById(id).get();

        election.setElectionName(electionName);

        electionRepository.save(election);

        return "redirect:/election/list";

    }

    @RequestMapping(value = "/election/delete/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") int id, Model model) {

        Election election = electionRepository.findById(id).get();

        electionRepository.delete(election);

        return "redirect:/election/list";
    }
    
}
