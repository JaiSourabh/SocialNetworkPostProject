package com.example.SocialPost.repositories;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.SocialPost.entities.SocialNetworkPost;
import com.example.SocialPost.entities.SocialNetworkPost.PostCategory;

@Repository
public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPost, Long> {
	 
	 List<SocialNetworkPost> findByAuthor(String author);
	 
	 @Query(value= "SELECT * FROM SocialNetworkPost WHERE postCategory = :category ORDER BY viewCount DESC limit 10", nativeQuery = true)
	 List<SocialNetworkPost> findTopPostsByCategory(@Param("category") String category);

	 @Query("SELECT p FROM SocialNetworkPost p WHERE p.author = :author")
	 Page<SocialNetworkPost> findPostsByAuthor(@Param("author") String author, Pageable pageable);
}

