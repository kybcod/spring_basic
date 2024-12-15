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

@Controller // ctrl+shift+o 자동 임포트
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService(); // 타입변환
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
		// 문자열 데이터를 '#'을 기준으로 나누어 String 배열로 변환
		//binder.setValidator(new UserValidator());
		binder.addValidators(new UserValidator());
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList : " + validatorList);;
	}
	
	
//	@RequestMapping(value="/register/add", method=RequestMethod.GET) // 신규회원 가입
	@GetMapping("/register/add") // 4.3부터 추가
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}

//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // 신규회원 가입
//	@PostMapping("/register/add")
	@PostMapping("/save")
	public String save(@Valid User user, Model m, BindingResult result) throws Exception {
		
		// 수동 검증 - Validator를 직접 생성하고, validate()를 직접 호출
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user,result); //BindingResult는 Errors의 자손
		
		if(result.hasErrors()) {
			return "registerForm";
		}
		
		/*
		 * if (!isValid(user)) { String msg = URLEncoder.encode("id를 잘못입력하셨습니다.",
		 * "utf-8");
		 * 
		 * m.addAttribute("msg", msg); return "redirect:/register/add"; // 신규회원 가입화면으로
		 * 이동(redirect) // return "redirect:/register/add?msg="+msg; //URL
		 * 재작성(rewriting) }
		 */

		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}

}