package com.example.SocialPost.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.SocialPost.entities.SocialNetworkPost;
import com.example.SocialPost.entities.SocialNetworkPost.PostCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
public class SocialNetworkPostRepositoryTest {

    @Mock
    private SocialNetworkPostRepository repository;

    private SocialNetworkPost post1;
    private SocialNetworkPost post2;

    @BeforeEach
    public void setUp() {
        post1 = new SocialNetworkPost(1L, new Date(), PostCategory.MUSIC, "John Doe", "Post Content 1", 100L);
        post2 = new SocialNetworkPost(2L, new Date(), PostCategory.GAMING, "Jane Doe", "Post Content 2", 200L);
    }

    @Test
    public void testFindByAuthor() {
        when(repository.findByAuthor("John Doe")).thenReturn(Arrays.asList(post1));

        List<SocialNetworkPost> posts = repository.findByAuthor("John Doe");
        assertNotNull(posts);
        assertEquals(1, posts.size());
        assertEquals("John Doe", posts.get(0).getAuthor());
    }

    @Test
    public void testFindTopPostsByCategory() {
        when(repository.findTopPostsByCategory("MUSIC")).thenReturn(Arrays.asList(post1));

        List<SocialNetworkPost> posts = repository.findTopPostsByCategory("MUSIC");
        assertNotNull(posts);
        assertEquals(1, posts.size());
        assertEquals(PostCategory.MUSIC, posts.get(0).getPostCategory());
    }

    @Test
    public void testFindPostsByAuthor() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<SocialNetworkPost> page = new PageImpl<>(Arrays.asList(post1));
        when(repository.findPostsByAuthor("John Doe", pageable)).thenReturn(page);

        Page<SocialNetworkPost> postsPage = repository.findPostsByAuthor("John Doe", pageable);
        assertNotNull(postsPage);
        assertEquals(1, postsPage.getTotalElements());
        assertEquals("John Doe", postsPage.getContent().get(0).getAuthor());
    }
}
