package org.java.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/")
	@ResponseBody
	public String test() {
		return "Hello world";
	}
	
	@GetMapping("/step1")
	public String test1(Model model) {
		
		final String name = "Andrea";
		
		model.addAttribute("name", name);
		
		return "index";
	}
}
