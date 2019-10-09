package com.hoya.webservice.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoya.webservice.domain.posts.PostsRepository;
import com.hoya.webservice.dto.posts.PostsSaverRequestDto;
import com.hoya.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

//	private PostsRepository postsRepository;
	private PostsService postsService;
	
	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld!";
	}
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("posts", postsService.findAllDesc());
		return "main";
	}
	
	
	@PostMapping("/posts")
	public long savePosts(@RequestBody PostsSaverRequestDto dto) { 
//		PostsRepository.save(dto.toEntity());
		return postsService.save(dto);
	}
	

	
	
	

}
