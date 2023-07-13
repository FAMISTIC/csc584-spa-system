<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%  // Retrieve the customer object from the request attributes
        net.system.model.Customer customer = (net.system.model.Customer) request.getAttribute("customer");
        if (customer != null) { 
    %>
        <table>
            <tr>
                <td>Customer ID:</td>
                <td><%= customer.getCustomerID() %></td>
            </tr>
            <tr>
                <td>Customer Name:</td>
                <td><%= customer.getCustomerNAME() %></td>
            </tr>
            <tr>
                <td>Customer Email:</td>
                <td><%= customer.getCustomerEMAIL() %></td>
            </tr>
            <tr>
                <td>Customer Contact:</td>
                <td><%= customer.getCustomerCONTACT() %></td>
            </tr>
        </table>
    <% 
        } else {
    %>
        <p>No customer details found.</p>
    <% 
        }
    %>
    
    <a href="logout.jsp">Logout</a>
</body>
</html>