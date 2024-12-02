package com.fastcampus.ch2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o 자동 임포트 
public class RegisterController {
	@RequestMapping(value="/register/add", method=RequestMethod.GET) // 신규회원 가입
	public String register() {
		return "registerForm";  // WEB-INF/views/registerForm.jsp
	}
	
	@RequestMapping(value="/register/save", method=RequestMethod.POST) // 신규회원 가입
	public String save() {
		return "registerInfo";
	}

	
}