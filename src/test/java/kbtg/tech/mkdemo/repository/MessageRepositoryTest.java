package kbtg.tech.mkdemo.repository;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.aspectj.weaver.Iterators;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
@JdbcTest
public class MessageRepositoryTest {

	@Autowired
	private MessageRepository messageRepository;
	
//	@Test
//	public void save_and_findbyid_of_new_message() {
//		Message newMessage = new Message();
//		newMessage.setData("batman");
//		messageRepository.save(newMessage);
//		//assertEquals(1, messageRepository.count());
//		Optional<Message> result = messageRepository.findById(newMessage.getId());
//		assertEquals("batman", result.get().getData());
//	}
	
	@Test
	public void save_and_count_of_a_message() {
		Message newMessage = new Message();
		newMessage.setData("batman");
		messageRepository.save(newMessage);
		
		Iterable<Message> allMessage = messageRepository.findAll();
		assertEquals(1, allMessage.spliterator().getExactSizeIfKnown());
	}

}
