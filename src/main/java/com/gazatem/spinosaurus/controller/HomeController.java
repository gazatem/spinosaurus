package com.gazatem.spinosaurus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gazatem.spinosaurus.domain.Customer;
import com.gazatem.spinosaurus.repository.*;

@RestController
@RequestMapping(value = "/")
public class HomeController {

	 
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String welcome() {
		return "Hello";
	}
	
 
	
	@RequestMapping(value="/greeting", method = RequestMethod.GET)
	@ResponseBody
	public String getGreeting() {
		return "greeting";
		
	}	
	
	
}
