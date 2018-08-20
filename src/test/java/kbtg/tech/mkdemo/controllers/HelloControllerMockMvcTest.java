package kbtg.tech.mkdemo.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import kbtg.tech.mkdemo.services.MessageService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers= HelloController.class)

public class HelloControllerMockMvcTest {

	@MockBean //mock bean and assign to spring context.
	MessageService messageService;
	
	@Autowired
	private MockMvc mocMvc;
	
	 @Before
	    public void setupMock() {
	        when(messageService.concat("somkiate")).thenReturn("Hello, somkiate");
	    }
	
	@Test
	public void success_with_code_200() throws Exception {
		mocMvc.perform(get("/hello/somkiate"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void success_with_correct_message() throws Exception {
		mocMvc.perform(get("/hello/somkiate"))
		.andExpect(
				jsonPath("$.message")
				.value("Hello, somkiate"));
	}

}
