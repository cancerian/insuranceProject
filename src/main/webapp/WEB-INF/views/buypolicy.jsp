<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>Buy Policy</h1>
    <form action="buynewpolicy" method="post">
     
        <label for="policyid">Policy ID:</label>
        <input type="text" name="policyid" id="policyid" required>
        
        
        <label for="policyname">Policy Name:</label>
        <select name="policyname" id="policyname">
            <option value="TATA AIG">TATA AIG</option>
            <option value="LIC">LIC</option>
            <option value="ICICI Lombard">ICICI Lombard</option>
            <!-- Add more policy options as needed -->
        </select>
        <br><br>
        
        <label for="insuranceTenure">Insurance Tenure in Yrs.:</label>
        <input type="text" name="insurance_tenure" id="insurance_tenure" required>
        <br><br>
        
        <label for="premiumAmount">Premium Amount:</label>
        <input type="text" name="premium_amount" id="premium_amount" required>
        <br><br>
        
        <label for="sumInsured">Sum Insured:</label>
        <input type="text" name="sum_insured" id="sum_insured" required>
        <br><br>
        
        <input type="submit" value="Buy" name="buy">
    </form>
</body>
</html>