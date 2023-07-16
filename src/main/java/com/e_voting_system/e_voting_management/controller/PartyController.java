package com.e_voting_system.e_voting_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.e_voting_system.e_voting_management.models.Party;
import com.e_voting_system.e_voting_management.models.Post;
import com.e_voting_system.e_voting_management.repository.PartyRepository;

@Controller
public class PartyController {
    @Autowired
    private PartyRepository partyRepository;
    
    
    @RequestMapping(value = "/party/list", method = RequestMethod.GET)
    public String post(Model model){
        model.addAttribute("party",partyRepository.findAll());
        model.addAttribute("allParty", partyRepository.count());
        return "post/list";
    }


    @RequestMapping(value = "/party/create", method = RequestMethod.GET)
    public String create(Model model){
        return "party/list";
    }

    @RequestMapping(value = "/party/add",method = RequestMethod.POST)
    public String add(Model model, @RequestParam String name){

        Party party = new Party(name);
        partyRepository.save(party);

        return "redirect:/party/list";
    }
    @RequestMapping(value = "/party/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") long id, Model model) {

        model.addAttribute("party", partyRepository.findById(id).get());
        return "post/edit";
    }

    @RequestMapping(value = "/party/update", method = RequestMethod.POST)
    public String updateParty(Model model, @RequestParam long id, @RequestParam String name) {

        Party party = partyRepository.findById(id).get();
        party.setName(name);
        partyRepository.save(party);

        return "redirect:/party/list";

    }
}
