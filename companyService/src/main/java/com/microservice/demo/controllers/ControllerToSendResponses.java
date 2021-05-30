package com.microservice.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.demo.EntityDtos.Employes;
import com.microservice.demo.EntityDtos.ResponseSent;

@RestController
public class ControllerToSendResponses {
	
	
	@RequestMapping("returnEmpDetails")
	public ResponseEntity<ResponseSent> returnEmpDetails() {
		
		Employes e1 = new Employes(1,"Yashi1");
		Employes e2 = new Employes(2,"Yashi2");
		Employes e3 = new Employes(3,"Yashi3");
		List<Employes> list = new ArrayList<Employes>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		ResponseSent responseSent = new ResponseSent();
		responseSent.setEmployes(list);
		
		//comment this while loop if u need real rest api to work.
		while(true) {
			System.out.println("You will not get any response from here now");
		}
		
		// and uncomment this
		//return new ResponseEntity<ResponseSent>(responseSent, HttpStatus.OK);
		
		
	}

}
