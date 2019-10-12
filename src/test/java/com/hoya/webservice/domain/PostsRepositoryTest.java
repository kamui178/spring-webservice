package com.hoya.webservice.domain;

import static org.hamcrest.CoreMatchers.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hoya.webservice.domain.posts.Posts;
import com.hoya.webservice.domain.posts.PostsRepository;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	@Ignore
	public void board_load() {
		//given
		postsRepository.save(Posts.builder()
				.title("test1")
				.content("test1_content")
				.author("test1@gmail.com")
				.build());
		
		// when
		List<Posts> postsList = postsRepository.findAll();
		
		// then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("test1"));
		assertThat(posts.getContent(), is("test1_content"));
	}
	
	@Test
//	@Ignore
	public void Register_BaseTimeEntity() {
		//given
		LocalDateTime now = LocalDateTime.now();
		postsRepository.save(Posts.builder()
				.title("test1")
				.content("test1_content")
				.author("test1@gmail.com")
				.build());
		
		//when
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertTrue(!posts.getCreateDate().isAfter(now));
		assertTrue(!posts.getModfiedDate().isAfter(now));
		
		
	}
}
