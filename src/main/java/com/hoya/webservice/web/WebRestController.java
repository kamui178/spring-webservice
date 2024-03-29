package com.hoya.webservice.web;

import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoya.webservice.dto.posts.PostsSaverRequestDto;
import com.hoya.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

//	private PostsRepository postsRepository;
	private PostsService postsService;
	private Environment env;
	
	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld!";
	}
	
	
	@PostMapping("/posts")
	public long savePosts(@RequestBody PostsSaverRequestDto dto) { 
//		PostsRepository.save(dto.toEntity());
		return postsService.save(dto);
	}
	
	@GetMapping("/profile")
	public String getProfile() {
		return Arrays.stream(env.getActiveProfiles())
				.findFirst()
				.orElse("");
	}
	

	
	
	

}
