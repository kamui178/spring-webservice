
package com.hoya.webservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hoya.webservice.domain.posts.Posts;
import com.hoya.webservice.domain.posts.PostsRepository;
import com.hoya.webservice.dto.posts.PostsSaverRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

	@Autowired
	private PostsService postsService;
	@Autowired
	private PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void dtoDataSave() {
		//given
		PostsSaverRequestDto dto = PostsSaverRequestDto.builder()
				.author("test1@gmail.com")
				.content("test1_content")
				.title("test1")
				.build();
		
		//when
		postsService.save(dto);
	
		Posts posts = postsRepository.findAll().get(0);
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
		assertThat(posts.getContent()).isEqualTo(dto.getContent());
		assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
	}
	
	
	
}
