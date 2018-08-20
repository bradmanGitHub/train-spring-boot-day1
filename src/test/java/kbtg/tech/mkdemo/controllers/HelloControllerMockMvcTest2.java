package kbtg.tech.mkdemo.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import kbtg.tech.mkdemo.controllers.response.HelloResponse;
import kbtg.tech.mkdemo.services.MessageService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerMockMvcTest2 {

	@MockBean // mock bean and assign to spring context.
	MessageService messageService;

	private JacksonTester<HelloResponse> tester;

	@Autowired
	private MockMvc mocMvc;

//	@BeforeClass // do only 1 time before invoke all test case.
//	public void initialja() {
//		JacksonTester.initFields(this, new ObjectMapper());
//	}

	@Before
	public void setupMock() {
		when(messageService.concat("somkiate")).thenReturn("Hello, somkiate");
	}

	@Test
	public void test() throws Exception {

		JacksonTester.initFields(this, new ObjectMapper());
		MockHttpServletResponse response = mocMvc.perform(get("/hello/somkiate")).andReturn().getResponse();

		String expected = tester.write(new HelloResponse("Hello, somkiate")).getJson();
		assertEquals(expected, response.getContentAsString());
	}

}
