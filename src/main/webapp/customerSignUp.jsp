<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
  <h1>Customer Register Form</h1>
  <form action="signup" method="post">
   <table style="with: 80%">
    <tr>
     <td>Username</td>
     <td><input type="text" name="customerNAME" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="customerPASSWORD" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="customerEMAIL" /></td>
    </tr>
    <tr>
     <td>Contact No</td>
     <td><input type="number" name="customerCONTACT" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
</body>
</html>