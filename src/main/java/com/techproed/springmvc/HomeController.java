package com.techproed.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller   //@Controller annotation is used to indicate that this is a controller class for all methods
public class HomeController {
	@RequestMapping("/")
	public String home() {
		
		return "index";
	}
	
	
	
	
}
