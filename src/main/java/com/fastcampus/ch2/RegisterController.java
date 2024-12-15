package com.fastcampus.ch2;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // ctrl+shift+o �ڵ� ����Ʈ
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService(); // Ÿ�Ժ�ȯ
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
		// ���ڿ� �����͸� '#'�� �������� ������ String �迭�� ��ȯ
		//binder.setValidator(new UserValidator());
		binder.addValidators(new UserValidator());
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList : " + validatorList);;
	}
	
	
//	@RequestMapping(value="/register/add", method=RequestMethod.GET) // �ű�ȸ�� ����
	@GetMapping("/register/add") // 4.3���� �߰�
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}

//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // �ű�ȸ�� ����
//	@PostMapping("/register/add")
	@PostMapping("/save")
	public String save(@Valid User user, Model m, BindingResult result) throws Exception {
		
		// ���� ���� - Validator�� ���� �����ϰ�, validate()�� ���� ȣ��
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user,result); //BindingResult�� Errors�� �ڼ�
		
		if(result.hasErrors()) {
			return "registerForm";
		}
		
		/*
		 * if (!isValid(user)) { String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.",
		 * "utf-8");
		 * 
		 * m.addAttribute("msg", msg); return "redirect:/register/add"; // �ű�ȸ�� ����ȭ������
		 * �̵�(redirect) // return "redirect:/register/add?msg="+msg; //URL
		 * ���ۼ�(rewriting) }
		 */

		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}

}