package com.kyung.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("chat")
	public String chat(){
		return "chat";
	}

}
