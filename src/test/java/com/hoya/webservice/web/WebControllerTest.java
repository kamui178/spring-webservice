package com.hoya.webservice.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
//	@Ignore
	public void load_mainPage() {
		// when
		String body = this.restTemplate.getForObject("/", String.class);
		
		// then
//		assertThat(body).contains("start springboot service");
	}

}
