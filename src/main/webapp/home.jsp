<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Success</title>
</head>
<body>
    <h1>Sign Up Successful</h1>
    <p>Username: <%= request.getAttribute("customerNAME") %></p>
    <p>Email   : <%= request.getAttribute("customerEMAIL") %></p>
    <p>PhoneNo : <%= request.getAttribute("customerCONTACT") %></p>
</body>
</html>