package com.techproed.springmvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	//@RequestMapping("addStudent")
	public String addStudent1 (@RequestParam("id") int a, @RequestParam("name") String b, Model m)
	{		
		Student student = new Student(a, b);
		m.addAttribute("studentObject",student);
		
		return "result.jsp";
	}
	
	//2 way
	//@RequestMapping("addStudent")	
	public String addStudent2 (@ModelAttribute Student student,Model m)
	{				
		m.addAttribute("studentObject",student);
		
		return "result.jsp";
	}
	
	//3 way
	//@RequestMapping("addStudent")	
	public String addStudent3 (@ModelAttribute("studentObject") Student student)
	{	
		return "result"; // added suffix in properties .jsp
	}
	
	//3.1 way
	@ModelAttribute
	public void greetStudent (Model m, Student student)
	{	
		m.addAttribute("greetStudent", student.getName());
	}
	
	//************Post request
	
	//1 way
	//@RequestMapping(value = "addStudent", method = RequestMethod.POST)	
	public String addStudent41 (@ModelAttribute("studentObject") Student student)
	{	
		return "result"; // added suffix in properties .jsp
	}
	
	//2 way
	@PostMapping("addStudent")	
	public String addStudent42 (@ModelAttribute("studentObject") Student student)
	{	
		return "result"; // added suffix in properties .jsp
	}
	
	//*************Get
	// 1 way get
	//@RequestMapping(value = "getStudent" , method=RequestMethod.GET)
	public String getStudent1 (Model m) {
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(101 , "Ali Can"));
		students.add(new Student(102 , "Veli Can"));
		students.add(new Student(103 , "Mary Star"));
		students.add(new Student(104 , "Tom Hanks"));
		students.add(new Student(105 , "Angie Ocean"));
		
		m.addAttribute("studentList" , students);
		
		return "result";
	}
	// 2 way get
	@GetMapping("getStudent")
	public String getStudent2 (Model m) {
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(101 , "Ali Can"));
		students.add(new Student(102 , "Veli Can"));
		students.add(new Student(103 , "Mary Star"));
		students.add(new Student(104 , "Tom Hanks"));
		students.add(new Student(105 , "Angie Ocean"));
		
		m.addAttribute("studentList" , students);
		
		return "result";
	}
	@GetMapping("getStudentWithId")
	public String getStudent3 (@RequestParam("id") int id, Model m) {
		List<Student> students = new ArrayList<>();
		students.add(new Student(101 , "Ali Can"));
		students.add(new Student(102 , "Veli Can"));
		students.add(new Student(103 , "Mary Star"));
		students.add(new Student(104 , "Tom Hanks"));
		students.add(new Student(105 , "Angie Ocean"));
		
		int idx = -1;
		
		for (Student student : students) {
			if(student.getId() == id) {
				idx = id;
				m.addAttribute("studentById" , student);
				}
		}
		if(idx == -1) { m.addAttribute("studentById" , "There is no student with id :"+ idx);}
		
		//another way
		/**
		 *  int idx = -1; //index value normally cannot be - , but if we put 0 it's the 1st index => -1 is a false index
        for (Student w : students) {
            if(id == w.getId()) {
                idx = students.indexOf(w);
            }
        }
        
        if (idx == -1) { //means there is no such id
            m.addAttribute("specificStudent" , "There is no such ID");
        } else {
            m.addAttribute("specificStudent" , students.get(idx));
        }
		 */
		return "result";
	}
	
}
