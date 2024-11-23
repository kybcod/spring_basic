<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Random" %>
<%-- <%! 클래스 영역 %> --%>
<%!  
	int getRandomInt(int range){
		return new Random().nextInt(range)+1;
	}
%>
<%-- <%  메서드 영역 - service()의 내부 %> --%>
<%
	int idx1 = getRandomInt(6);
	int idx2 = getRandomInt(6);
%>
<html>
<head>
	<title>twoDice.jsp</title>
</head>
<body>
	<img src='resources/img/dice<%=idx1%>.jpg'>
	<img src='resources/img/dice<%=idx2%>.jpg'>
</body>
</html>

<!-- 첫번 째 호출 : 시간 지연, 변환하고 컴파일 과정 거쳐야함
두번쨰 호출 : 바로 서블릿 인스턴스
서블릿은 늦은 초기화 스프링은 얼리 초기화 둘다 싱글톤 -->