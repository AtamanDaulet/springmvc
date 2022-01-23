package com.techproed.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {
	// 1 way:
	
	//@RequestMapping("add")
	public String addNums1(HttpServletRequest request) {
		
		int a = Integer.parseInt(request.getParameter("n1"));
		int b = Integer.parseInt(request.getParameter("n2"));
		int sum = a+b;
		
		int product = a*b;
		
		HttpSession session = request.getSession();
		session.setAttribute("sumOfTwoIntegers", sum);
		session.setAttribute("productOfTwoIntegers", product);
				
		return "result.jsp";
	}
	// 2 way:
	//@RequestMapping("add")
	public String addNums2 (@RequestParam("n1") int a, @RequestParam("n2") int b, HttpSession session)
	{
		int sum = a+b;
		
		int product = a*b;		
		
		session.setAttribute("sumOfTwoIntegers", sum);
		session.setAttribute("productOfTwoIntegers", product);
		
		return "result.jsp";
	}
	// 3 way:
	//@RequestMapping("add")
	public ModelAndView addNums3 (@RequestParam("n1") int a, @RequestParam("n2") int b)
	{
		ModelAndView mv = new ModelAndView();	
		mv.setViewName("result.jsp");
		
		int sum = a+b;		
		int product = a*b;		
		
		mv.addObject("a", a);
		mv.addObject("b", b);
		mv.addObject("sumOfTwoIntegers", sum);
		mv.addObject("productOfTwoIntegers", product);
		
		return mv;
	}
	// 4 way:
	//@RequestMapping("add")
	public ModelAndView addNums4 (@RequestParam("n1") int a, @RequestParam("n2") int b)
	{
		ModelAndView mv = new ModelAndView("result.jsp");
		
		int sum = a+b;		
		int product = a*b;		
		
		mv.addObject("inputValueA", a);
		mv.addObject("inputValueB", b);
		mv.addObject("sumOfTwoIntegers", sum);
		mv.addObject("productOfTwoIntegers", product);
		
		return mv;
	}
	// 5 way:
	//@RequestMapping("add")
	public String addNums5 (@RequestParam("n1") int a, @RequestParam("n2") int b, Model m)
	{
		
		
		int sum = a+b;		
		int product = a*b;		
	//5.1 way
//		m.addAttribute("inputValueA", a);
//		m.addAttribute("inputValueB", b);
//		m.addAttribute("sumOfTwoIntegers", sum);
//		m.addAttribute("productOfTwoIntegers", product);
	//5.2 way	
		m.addAttribute("inputValueA", a).addAttribute("inputValueB", b).
			addAttribute("sumOfTwoIntegers", sum).
			addAttribute("productOfTwoIntegers", product);
		
		return "result.jsp";
	}
		
	// 6 way:
	//@RequestMapping("add")
	public String addNums6 (@RequestParam("n1") int a, @RequestParam("n2") int b, ModelMap mm)
	{			
		int sum = a+b;		
		int product = a*b;		
		
		mm.addAttribute("inputValueA", a).addAttribute("inputValueB", b).
		addAttribute("sumOfTwoIntegers", sum).
		addAttribute("productOfTwoIntegers", product);
	
		return "result.jsp";
	}
	
	//*****************Student
	
	//1 way
	@RequestMapping("addStudent")
	public String addStudent1 (@RequestParam("id") int a, @RequestParam("name") String b, Model m)
	{		
		Student student = new Student(a, b);
		m.addAttribute("studentObject",student);
		
		return "result.jsp";
	}
	
	
	
	
}
