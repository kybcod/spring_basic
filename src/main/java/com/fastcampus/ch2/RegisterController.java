package com.fastcampus.ch2;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionException;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	}
	
	
//	@RequestMapping(value="/register/add", method=RequestMethod.GET) // �ű�ȸ�� ����
	@GetMapping("/register/add") // 4.3���� �߰�
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}

//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // �ű�ȸ�� ����
// 	@PostMapping("/register/save")
	@PostMapping("/register/add")
	public String save(@ModelAttribute("user") User user, Model m, BindingResult result) throws Exception {
		
		if (!isValid(user)) {
			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.", "utf-8");

			m.addAttribute("msg", msg);
			return "redirect:/register/add"; // �ű�ȸ�� ����ȭ������ �̵�(redirect)
			// return "redirect:/register/add?msg="+msg; //URL ���ۼ�(rewriting)
		}

		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}

}