package net.system.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import net.system.dao.EmployeeLoginDao;
import net.system.model.Employee;

@WebServlet("/login")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeLoginDao employeeloginDao;

    public void init() {
        employeeloginDao = new EmployeeLoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	// Retrieve the values of username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Employee employee = new Employee();
 
        employee.setUsername(username);
        employee.setPassword(password);
        
        // Set the values as attributes in the request
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
        System.out.println("Data : " + employee);
        
        // Forward the request to loginsuccess.jsp
        try {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("loginsuccess.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
