package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿의 생명주기(초기화, 서비스, 소멸)
// 서블릿 : 싱글톤(1개의 인스턴스를 만들어 재활용)
@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	// 처음에 한번만 호출
	@Override
	public void init() throws ServletException {
		// 서블릿이 초기화될 때 자동 호출
		// 1. 서블릿의 초기화 작업 담당
		System.out.println("[HelloServlet] init() is called.");
	}

	// 요청이 올 때마다 반복적으로 호출
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 입력
		// 2. 처리
		// 3. 출력
		System.out.println("[HelloServlet] service() is called.");
	}

	// 리로드
	@Override
	public void destroy() {
		// 3. 뒷정리 - 서블릿이 메모리에서 제거될 때 서블릿 컨테이너에 의해서 자동 호출
		System.out.println("[HelloServlet] destroy() is called.");
	}


}
