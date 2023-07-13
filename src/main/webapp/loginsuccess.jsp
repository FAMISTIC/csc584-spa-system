<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Success</title>
</head>
<body>
    <h1>Login Successful</h1>
    <p>Username: <%= request.getAttribute("username") %></p>
    <p>Password: <%= request.getAttribute("password") %></p>
</body>
</html>