<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result page</title>
</head>
<body>
<!--  
	<h1>Result: </h1>
	Result of addition operation(${inputValueA} + ${inputValueB}) is: ${sumOfTwoIntegers}
	<br>
	<br>
	Result of product operation(${inputValueA} * ${inputValueB}) is: ${productOfTwoIntegers}
	-->
	
	<h1>Result: </h1>
	Student added: ${studentObject}
	<br>
	Student id : ${studentObject.id}
	<br>
	Student name : ${studentObject.name}
	<br>
	<h1>Greeting: </h1>
	Welcome back ${greetStudent}
	
	<h1>Student list: </h1>
	All students are :${studentList}
	
	<h1>Get a specific student with id:  </h1>
	The student which you selected is ${studentById}
	
</body>
</html>