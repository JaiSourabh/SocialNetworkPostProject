package com.example.SocialPost.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SocialPost.entities.SocialNetworkPost;
import com.example.SocialPost.entities.SocialNetworkPost.PostCategory;
import com.example.SocialPost.repositories.SocialNetworkPostRepository;
import com.example.SocialPost.services.SocialNetworkPostService;

@RestController
@RequestMapping("/api/posts")
public class SocialNetworkPostController {
	  
		@Autowired
	    private SocialNetworkPostService service;
		
		@Autowired
		private SocialNetworkPostRepository repository;
	    
		//Expose an API to search posts by author
	    @GetMapping("/author/{author}")
	    public List<SocialNetworkPost> getPostsByAuthor(@PathVariable String author) {
	        return service.getPostsByAuthor(author);
	    }
	    
	    //Expose an API to return posts with the top ten highest view counts per postCategory
	    @GetMapping("/top")
	    public List<SocialNetworkPost> getTopPostsByCategory(@RequestParam String category) {
	        return service.getTopPostByCategory(category);
	    }
	    
	    //Design this API also consider scalability and performance aspects.
	    //This API works for other DB than H2.
	    @GetMapping("/search")
	    public Page<SocialNetworkPost> getPostsByAuthor(
	            @RequestParam String author,
	            @RequestParam int page,
	            @RequestParam int size) {
	        Pageable pageable = PageRequest.of(page, size);
	        return repository.findPostsByAuthor(author, pageable);
}

}