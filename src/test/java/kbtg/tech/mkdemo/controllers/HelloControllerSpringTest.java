package kbtg.tech.mkdemo.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import kbtg.tech.mkdemo.controllers.response.HelloResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerSpringTest {
	
	@Autowired
	private TestRestTemplate rest;

	@Test
	public void sayHi() {
		HelloResponse actualResult = rest.getForObject("/hello/somkiate", HelloResponse.class);
		assertEquals("Hello, somkiate", actualResult.getMessage());
			
	}

}
