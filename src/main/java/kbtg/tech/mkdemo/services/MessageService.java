package kbtg.tech.mkdemo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import kbtg.tech.mkdemo.repository.Message;
import kbtg.tech.mkdemo.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	public String concat(String name){
		return "Hello, "+name;
	}
	
	public String getNameById(int id){
		Optional<Message> message = messageRepository.findById(id);
		if(message.isPresent()){
			return "Hello, "+ message.get().getData();
		}
		
		return "Not Found";
	}

	public void setMessageRepository(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
		
	}
}
