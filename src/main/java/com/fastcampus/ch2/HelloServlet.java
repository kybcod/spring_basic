package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ������ �����ֱ�(�ʱ�ȭ, ����, �Ҹ�)
// ���� : �̱���(1���� �ν��Ͻ��� ����� ��Ȱ��)
@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	// ó���� �ѹ��� ȣ��
	@Override
	public void init() throws ServletException {
		// ������ �ʱ�ȭ�� �� �ڵ� ȣ��
		// 1. ������ �ʱ�ȭ �۾� ���
		System.out.println("[HelloServlet] init() is called.");
	}

	// ��û�� �� ������ �ݺ������� ȣ��
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. �Է�
		// 2. ó��
		// 3. ���
		System.out.println("[HelloServlet] service() is called.");
	}

	// ���ε�
	@Override
	public void destroy() {
		// 3. ������ - ������ �޸𸮿��� ���ŵ� �� ���� �����̳ʿ� ���ؼ� �ڵ� ȣ��
		System.out.println("[HelloServlet] destroy() is called.");
	}


}
