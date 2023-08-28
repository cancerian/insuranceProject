<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Delete Policy</h1>
    <form action="deletpolicyold" method="post">
     
        
        
        <label for="policyname">Policy Name:</label>
        <select name="policyname" id="policyname">
            <option value="policy1">TATA AIG</option>
            <option value="policy2">LIC</option>
            <option value="policy3">ICICI Lombard</option>
            <!-- Add more policy options as needed -->
        </select>
        <br><br>
        
       
        
       
        <input type="submit" value="Delete" name="delete">
    </form>
</body>
</html>