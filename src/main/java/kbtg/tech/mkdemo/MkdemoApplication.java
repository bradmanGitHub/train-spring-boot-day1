package kbtg.tech.mkdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kbtg.tech.mkdemo.repository.Message;
import kbtg.tech.mkdemo.repository.MessageRepository;

@SpringBootApplication
public class MkdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MkdemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initialData(final MessageRepository repository){
		return new CommandLineRunner() {
			public void run(String... args) throws Exception {
				Message message = new Message();
				message.setData("batman");
				repository.save(message);
				
				Message message2 = new Message();
				message2.setData("jordan");
				repository.save(message2);
			}
		};
		
		
	}
}
