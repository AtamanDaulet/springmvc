<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC Tutorial</title>
</head>
<body>
	<h1>Welcome to Spring MVC Course</h1>
	<p>
		Spring boot makes project creation easier <br>
		<br> Spring Boot is the most common framework in the market
	</p>

	<h1>Get two integers from the user</h1>
	<form action="add">
		Enter first integer: <input type="text" name="n1"> 
		<br>
		<br> 
		Enter second integer: <input type="text" name="n2">
		<br>
		<br> <input type="submit">

	</form>

	 <!-- <h1>Add student</h1>
	<form action="addStudent" >
		Enter student's id: <input type="text" name="id"> 
		<br>
		<br> 
		Enter student's name: <input type="text" name="name">
		<br>
		<br> <input type="submit">

	</form>-->

 <!--1 way post <h1>Add student post</h1>
	<form action="addStudent" , method="post">
		Enter student's id: <input type="text" name="id"> 
		<br>
		<br> 
		Enter student's name: <input type="text" name="name">
		<br>
		<br> <input type="submit">

	</form>-->
	
	<!--<h1>Get all students</h1>
	<form action="getStudent" method="get">
		Enter student's id: <input type="text" name="id"> 
		<br>		
		<br> <input type="submit">
	</form>-->

	<h1>Get student by Id</h1>
	<form action="getStudentWithId" method="get">
		Enter student's id: <input type="text" name="id"> 
		<br>		
		<br> <input type="submit">
	</form>
	
	
</body>
</html>