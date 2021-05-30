package com.microservice.demo.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.demo.entityDtos.Employes;
import com.microservice.demo.entityDtos.ResponseRecieved;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController

public class ControllersForFetchingEmpls {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/fetchEmpList")
	@HystrixCommand(fallbackMethod="handleSlowness")
	public ResponseEntity<ResponseRecieved> getEmpsFromCompanyService() {
		
		ResponseEntity<ResponseRecieved> recieved = restTemplate.getForEntity("http://Company-Service/returnEmpDetails", ResponseRecieved.class);
		return recieved;
	}
	
	private ResponseEntity<ResponseRecieved> handleSlowness() {
		ResponseRecieved res = new ResponseRecieved();
		res.setEmployes(Arrays.asList(new Employes(0,"no name")));
		return new ResponseEntity<ResponseRecieved>(res, HttpStatus.OK);

	}

}
