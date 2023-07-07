package com.e_voting_system.e_voting_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e_voting_system.e_voting_management.repository.CandidateRepository;

import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CandidateController {
    
    @Autowired
    private CandidateRepository candidateRepository;


    @RequestMapping(value = "/candidate/List", method = RequestMethod.GET)
    public String candidate(Model model){

        model.addAttribute("candidate",candidateRepository.findAll());
        model.addAttribute("allCandidate", candidateRepository.count());

        return "candidate/list";
    }
}
