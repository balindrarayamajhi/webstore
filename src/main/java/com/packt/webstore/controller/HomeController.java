package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller 
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/")
	public String welcome(Model model,RedirectAttributes redirectAttributes) {

		model.addAttribute("greeting", "Welcome to Web Store"); 
		model.addAttribute("tagline", "The one and only amazing web store");
		return "welcome";
		

	}
	
	
}