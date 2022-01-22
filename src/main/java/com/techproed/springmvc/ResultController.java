package com.techproed.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResultController {
	// 1 way:
	
	@RequestMapping("add")
	public String addNums1(HttpServletRequest request) {
		
		int a = Integer.parseInt(request.getParameter("n1"));
		int b = Integer.parseInt(request.getParameter("n2"));
		int sum = a+b;
		
		HttpSession session = request.getSession();
		session.setAttribute("sumOfTwoIntegers", sum);
		
		return "result.jsp";
	}
}
