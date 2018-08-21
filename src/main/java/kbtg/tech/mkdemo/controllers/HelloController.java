package kbtg.tech.mkdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kbtg.tech.mkdemo.controllers.response.HelloResponse;
import kbtg.tech.mkdemo.services.MessageService;

@RestController
public class HelloController {
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/hello/{name}")
	public HelloResponse sayHi(@PathVariable String name){
		String result = messageService.concat(name);
		//return new HelloResponse(name);
		return new HelloResponse(result);
	}
	
	@GetMapping("/hey/{id}")
	public HelloResponse hey(@PathVariable int id){
		String result = messageService.getNameById(id);
		return new HelloResponse(result);
	}

	public void setMessageService(MessageService messageService) {
		// TODO Auto-generated method stub
		this.messageService = messageService;
	}
}
