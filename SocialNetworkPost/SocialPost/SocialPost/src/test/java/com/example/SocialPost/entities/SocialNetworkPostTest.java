package com.example.SocialPost.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SocialNetworkPostTest {
	 private SocialNetworkPost post;

	    @BeforeEach
	    public void setUp() {
	        post = new SocialNetworkPost();
	        post.setId(1L);
	        post.setPostDate(new Date());
	        post.setPostCategory(SocialNetworkPost.PostCategory.MUSIC);
	        post.setAuthor("John Doe");
	        post.setContent("This is a test post.");
	        post.setViewCount(100L);
	    }

	    @Test
	    public void testPostId() {
	        assertEquals(1L, post.getId());
	    }

	    @Test
	    public void testPostDate() {
	        assertNotNull(post.getPostDate());
	    }

	    @Test
	    public void testPostCategory() {
	        assertEquals(SocialNetworkPost.PostCategory.MUSIC, post.getPostCategory());
	    }

	    @Test
	    public void testAuthor() {
	        assertEquals("John Doe", post.getAuthor());
	    }

	    @Test
	    public void testContent() {
	        assertEquals("This is a test post.", post.getContent());
	    }

	    @Test
	    public void testViewCount() {
	        assertEquals(100L, post.getViewCount());
	    }
}
