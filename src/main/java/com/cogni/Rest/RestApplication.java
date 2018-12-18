package com.cogni.Rest;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(
				RestApplication.class, args);
		
		ConsumerClient consumerClient=ctx.getBean(ConsumerClient.class);
		System.out.println("Calling from client"+consumerClient);
		consumerClient.getEmployee();
		
	}
	
	@Bean
	public  ConsumerClient  consumerClient()
	{
		return  new ConsumerClient();
	}
}
