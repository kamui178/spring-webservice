package com.hoya.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoya.webservice.domain.posts.PostsRepository;
import com.hoya.webservice.dto.posts.PostsSaverRequestDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private PostsRepository PostsRepository;
	
	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld!";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaverRequestDto dto) { // ¸¸µé±â
		PostsRepository.save(dto.toEntity());
	}
	
	
	

}
