package com.hoya.webservice.domain;

import static org.hamcrest.CoreMatchers.is;

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
		// 테스트 완료후 repository 전체를 비우는 코드
		
		postsRepository.deleteAll();
		
	}
	
	@Test
	@Ignore
	public void board_load() {
		//given
		postsRepository.save(Posts.builder()
				.title("test title")
				.content("test content")
				.author("test@hoya.com")
				.build());
		
		// when
		List<Posts> postsList = postsRepository.findAll();
		
		// then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("test title"));
		assertThat(posts.getContent(), is("test content"));
	}
	
	@Test
	public void Register_BaseTimeEntity() {
		//given
		LocalDateTime now = LocalDateTime.now();
		postsRepository.save(Posts.builder()
				.title("test title")
				.content("test content")
				.author("test@gmail.com")
				.build());
		//when
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertTrue(posts.getCreateDate().isAfter(now));
		assertTrue(posts.getModfiedDate().isAfter(now));
	}
}
