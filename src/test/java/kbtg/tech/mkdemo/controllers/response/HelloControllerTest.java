package kbtg.tech.mkdemo.controllers.response;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class HelloControllerTest {

	@Test //@Ignore
	public void send_Hanaga_should_return_HelloHanaga() {
		HelloResponse hr = new HelloResponse("Batman");
		String actualResult = hr.getMessage();
		assertEquals("Hello, Batman", actualResult);
	}
	
	@Test
	public void set_HanagaModify_should_return_HelloHanagaModify() {
		HelloResponse hr = new HelloResponse("Hanaga");
		hr.setMessage("Hello, HanagaModify");
		String actualResult = hr.getMessage();
		assertEquals("Hello, HanagaModify", actualResult);
	}

}
