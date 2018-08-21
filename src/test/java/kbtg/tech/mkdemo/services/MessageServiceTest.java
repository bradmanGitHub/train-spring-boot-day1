package kbtg.tech.mkdemo.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import kbtg.tech.mkdemo.repository.Message;
import kbtg.tech.mkdemo.repository.MessageRepository;

public class MessageServiceTest {

	@Mock
	private MessageService messageService;

	@Mock
	private MessageRepository messageRepository;
	
	@Before
	public void initial(){
		initMocks(this);
		
		messageService = new MessageService();
		messageService.setMessageRepository(messageRepository);
	}

	@Test
	public void test() {
		Message newMessage = new Message();
		newMessage.setData("batman");

		when(messageRepository.findById(1)).thenReturn(Optional.of(newMessage));
		
		String actualResult = messageService.getNameById(1);
		assertEquals("Hello, batman", actualResult);
	}

}
