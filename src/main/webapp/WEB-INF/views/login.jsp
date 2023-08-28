<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form action="userlogin" method="post">
		<label for="loginid">Login ID:</label>
		 <input type="text"name="loginid" required><br> <br> 
		 <label for="password">Password:</label> 
		 <input type="password" name="password" required><br> <br>
		<button type="submit">Login</button>
	</form>

</body>
</html>