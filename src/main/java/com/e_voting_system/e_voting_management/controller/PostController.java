package com.e_voting_system.e_voting_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.e_voting_system.e_voting_management.models.Post;
import com.e_voting_system.e_voting_management.repository.PostRepository;

@Controller
public class PostController {
    
    @Autowired
    private PostRepository postRepository;
    
    
    @RequestMapping(value = "/post/list", method = RequestMethod.GET)
    public String post(Model model){
        model.addAttribute("post",postRepository.findAll());
        model.addAttribute("allPost", postRepository.count());
        return "post/list";
    }


    @RequestMapping(value = "/post/create", method = RequestMethod.GET)
    public String create(Model model){
        return "post/list";
    }

    @RequestMapping(value = "/post/add",method = RequestMethod.POST)
    public String add(Model model, @RequestParam String name){

        Post post = new Post(name);
        postRepository.save(post);

        return "redirect:/post/list";
    }
    @RequestMapping(value = "/post/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") long id, Model model) {

        model.addAttribute("post", postRepository.findById(id).get());
        return "post/edit";
    }

    @RequestMapping(value = "/post/update", method = RequestMethod.POST)
    public String updatePost(Model model, @RequestParam long id, @RequestParam String name) {

        Post post = postRepository.findById(id).get();
        post.setName(name);
        postRepository.save(post);

        return "redirect:/post/list";

    }
}
