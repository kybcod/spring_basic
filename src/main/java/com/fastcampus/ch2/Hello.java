package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. ���� ȣ�Ⱑ���� ���α׷����� ���
@Controller
// �ν��Ͻ� �޼���
public class Hello {
	
	int iv = 10;
	static int cv = 20;
	
	// 2. URL�� �޼��� ����
	@RequestMapping("/hello")
	public void main() { // �ν��Ͻ� �޼���, - iv, cv ��� ��� ����
		System.out.println("hello");
	}
	
	public static void main2() { //static �޼��� - cv�� ��밡��
		System.out.println(cv);//ok
		// System.out.println(iv); //����
	}
}

// URL�� ���� ���α׷� �����ϸ� ��Ĺ�� ��ü ���� ���� �׷��� static ���� �ν��Ͻ� �޼��� ȣ�� ����