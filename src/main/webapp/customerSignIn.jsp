<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>Sign In</h1>
  <form action="signin" method="post">
   <table style="with: 80%">
    <tr>
     <td>UserName</td>
     <td><input type="text" name="customerNAME" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="customerPASSWORD" /></td>
    </tr>

   </table>
   <input type="submit" value="Submit" />
  </form>
</body>
</html>