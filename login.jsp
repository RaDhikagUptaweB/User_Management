<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login form</title>
</head>
<body>
<header>
<img alt="teliolabs" src="https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.teliolabs.com%2F&psig=AOvVaw3p2GZ7QN0_Gle5LmX7BVnt&ust=1700650474296000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCLCkku321IIDFQAAAAAdAAAAABAE">
</header>
<h1>Login Form</h1>
<form action="LoginServlet" method="post">
<table>
<tr><td>Email: </td><td><input type="text" name="email"></td></tr>
<tr><td>Password: </td><td><input type="password" name="password"></td></tr>
</table>
<tr><td colspan="2"><input type="submit" value="Login"/></td></tr>
<tr>
    <td colspan="2">
        <a href="index.jsp">Register</a>
    </td>
</tr>

  
</form>
</body>
</html>