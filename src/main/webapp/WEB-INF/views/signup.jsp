<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>SignUp</h1>
    <form action="signup" method="post">
        <label for="loginid">Login ID:</label>
        <input type="text" id="loginid" name="loginid" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
         <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        
         <label for="address">Address:</label>
        <input type="text" id="address" name="address" required><br><br>
        
         <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="mobile">Mobile No:</label>
        <input type="text" id="mobile" name="mobile" required><br><br>
        
        <input type="submit" value="SignUp">
    </form>
 
   

</body>
</html>