package com.example.SocialPost.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.SocialPost.entities.SocialNetworkPost;
import com.example.SocialPost.repositories.SocialNetworkPostRepository;

public class SocialNetworkPostServiceTest {
	 	@Mock
	    private SocialNetworkPostRepository repository;

	    @InjectMocks
	    private SocialNetworkPostService service;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    public void testGetPostsByAuthor() {
	        String author = "John Doe";
	        List<SocialNetworkPost> mockPosts = Arrays.asList(new SocialNetworkPost(), new SocialNetworkPost());
	        when(repository.findByAuthor(author)).thenReturn(mockPosts);

	        List<SocialNetworkPost> posts = service.getPostsByAuthor(author);

	        assertNotNull(posts);
	        assertEquals(2, posts.size());
	        verify(repository, times(1)).findByAuthor(author);
	    }

	    @Test
	    public void testGetTopPostByCategory() {
	        String category = "Technology";
	        List<SocialNetworkPost> mockPosts = Arrays.asList(new SocialNetworkPost(), new SocialNetworkPost());
	        when(repository.findTopPostsByCategory(category)).thenReturn(mockPosts);

	        List<SocialNetworkPost> posts = service.getTopPostByCategory(category);

	        assertNotNull(posts);
	        assertEquals(2, posts.size());
	        verify(repository, times(1)).findTopPostsByCategory(category);
	    }
}
