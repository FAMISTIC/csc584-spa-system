package net.system.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import net.system.dao.EmployeeRegisterDao;
import net.system.model.Employee;

@WebServlet("/register")
public class EmployeeRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeRegisterDao employeeRegisterDao;

    public void init() {
        employeeRegisterDao = new EmployeeRegisterDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setContact(contact);
        employee.setAddress(address);
        
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("address", address);
        request.setAttribute("contact", contact);
        
        System.out.println("Data : " + employee);
        try {
            employeeRegisterDao.registerEmployee(employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employeedetails.jsp");
            dispatcher.forward(request, response); 
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}