package com.example.SocialPost.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SocialPost.entities.SocialNetworkPost;
import com.example.SocialPost.entities.SocialNetworkPost.PostCategory;
import com.example.SocialPost.repositories.SocialNetworkPostRepository;

@Service
public class SocialNetworkPostService {
	
	@Autowired
    private SocialNetworkPostRepository repository;
    
    public List<SocialNetworkPost> getPostsByAuthor(String author) {
        return repository.findByAuthor(author);
    }
    
    public List<SocialNetworkPost> getTopPostByCategory(String category){
    	return repository.findTopPostsByCategory(category);
    }
}
