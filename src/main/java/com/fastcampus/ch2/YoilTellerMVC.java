package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC {
	@RequestMapping("/getYoilMVC")
    //public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public String main(int year, int month, int day, Model model) throws IOException {
        // HttpServletResponse response : view를 따로 주기 떄문에 response 따로 필요 없음

		//1. 유효성 검사
		if(!isValid(year, month, day)) {
			return "yoilError";
		}
		
        // 2. 요일 계산
        char yoil = getYoil(year, month, day);

        // 3. 계산할 결과를 model에 저장
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);
        
        return "yoil"; //jsp 파일
       
    }

	private boolean isValid(int year, int month, int day) {
		
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        //cal.set(yyyy, mm - 1, dd);
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);   // 일요일:1, 월요일:2, ... 
	}
}

// url이 요청을 하면 톰캣이 HttpServletRequest 객체를 만들어 정보를 담아서 서러에 전달
// 클라이언트 : 서비스를 요청하는 애플리케이션
// 서버 : 서비스를 제공하는 애플리케이션 