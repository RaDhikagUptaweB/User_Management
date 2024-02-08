<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>  
<html>  
<head>  
<meta charset="ISO-8859-1">  
<title>Insert title here</title> 
</head>  
<body>  
  
<h1>Register</h1>  
<form action="SaveServlet" method="post">  
<table>  
<tr><td>First_Name:</td><td><input type="text" name="fname" required/></td></tr>
<tr><td>Last_Name:</td><td><input type="text" name="lname" required/></td></tr>
<tr><td>Email:</td><td><input type="email" name="email" required/></td></tr>    
<tr><td>Password:</td><td><input type="password" name="password" required/></td></tr>  
<tr><td>Confirm_Password:</td><td><input type="password" name="confirm_password" required/></td></tr>  
<tr><td>Cell_Nos:</td><td><input type="number" name="cell_nos" required/></td></tr>  
<tr><td>Profession:</td><td>  
<select name="Profession" style="width:150px">  
<option>Developer</option>  
<option>consultant</option>  
<option>HR</option>  
<option>Other</option>  
</select>  
</td></tr>  
<tr><td colspan="2"><input type="submit" value="Register"/></td></tr>  
<tr>
    <td colspan="2">
        <a href="login.jsp">Login</a>
    </td>
</tr>

</table> 

    
    
</form>  
  
<br/>  
<a href="ViewServlet">view employees</a>  
</body>
</html> 