package com.e_voting_system.e_voting_management.repository;

import org.springframework.data.repository.CrudRepository;

import com.e_voting_system.e_voting_management.models.Post;

public interface PostRepository extends CrudRepository<Post, Long>{

    Post findPostByName(String post);
}
