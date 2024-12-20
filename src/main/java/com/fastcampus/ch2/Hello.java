package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 호출가능한 프로그램으로 등록
@Controller
// 인스턴스 메서드
public class Hello {
	
	int iv = 10;
	static int cv = 20;
	
	// 2. URL과 메서드 연결
	@RequestMapping("/hello")
	public void main() { // 인스턴스 메서ㄷ, - iv, cv 모두 사용 가능
		System.out.println("hello");
	}
	
	public static void main2() { //static 메서드 - cv만 사용가능
		System.out.println(cv);//ok
		// System.out.println(iv); //에러
	}
}

// URL로 원격 프로그램 실행하면 톰캣이 객체 생성 해줌 그래서 static 없는 인스턴스 메서드 호출 가능