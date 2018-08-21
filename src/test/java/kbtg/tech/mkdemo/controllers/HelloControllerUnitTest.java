package kbtg.tech.mkdemo.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import kbtg.tech.mkdemo.controllers.response.HelloResponse;
import kbtg.tech.mkdemo.services.MessageService;

public class HelloControllerUnitTest {

	@Mock
	private MessageService messageService;
	
	private HelloController helloController;
	
	@Before
	public void initial(){
		initMocks(this);
		helloController = new HelloController();
		helloController.setMessageService(messageService);
	}

	@Test
	public void input_batman_should_return_hellobatman() {
		when(messageService.concat("batman")).thenReturn("Hello, batman");
		
		HelloResponse response = helloController.sayHi("batman");
		String expectedValue = "Hello, batman";
		assertEquals(expectedValue, response.getMessage());
	}

}
