package com.fastcampus.ch2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o �ڵ� ����Ʈ 
public class RegisterController {
	@RequestMapping(value="/register/add", method=RequestMethod.GET) // �ű�ȸ�� ����
	public String register() {
		return "registerForm";  // WEB-INF/views/registerForm.jsp
	}
	
	@RequestMapping(value="/register/save", method=RequestMethod.POST) // �ű�ȸ�� ����
	public String save() {
		return "registerInfo";
	}

	
}