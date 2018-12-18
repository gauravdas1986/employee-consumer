package com.cogni.Rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.cogni.bo.Employee;

@RestController
@RequestMapping("/rest")
public class AppController {

	@Autowired
	private ApplicationContext appContext;
	
	@RequestMapping(value = "/getemp", method = RequestMethod.GET)
	public Employee getEmployee() throws RestClientException, IOException {

		 /*ApplicationContext ctx = SpringApplication.run(
				RestApplication.class, "");*/
		
		ConsumerClient consumerClient= appContext.getBean(ConsumerClient.class);
		Employee emp = consumerClient.getEmployee();

		return emp;
	}

}
