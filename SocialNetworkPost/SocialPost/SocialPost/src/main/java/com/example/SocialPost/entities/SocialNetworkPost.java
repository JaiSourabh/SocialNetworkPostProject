package com.example.SocialPost.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "socialnetworkpost")
public class SocialNetworkPost {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	
		@Column(name = "postdate")
	    private Date postDate;
		
		@Enumerated(EnumType.STRING)
		@Column(name="postcategory")
	    private PostCategory postCategory; // ENUM for post categories
	    
	    @Column(name = "author")
	    private String author;
	    
	    @Column(name = "content")
	    private String content;
	    
	    @Column(name = "viewcount")
	    private Long viewCount;
	    

	    // ENUM for post categories
	    public enum PostCategory {
	        MUSIC, GAMING, NEWS, ENTERTAINMENT
	    }
}
