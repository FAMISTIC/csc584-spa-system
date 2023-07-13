package net.system.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import net.system.dao.CustomerLoginDao;
import net.system.model.Customer;


@WebServlet("/signin")
public class CustomerLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomerLoginDao customerLoginDao;
	
	public void init() {
		customerLoginDao = new CustomerLoginDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the values of username and password from the request
        String customerNAME = request.getParameter("customerNAME");
        String customerPASSWORD = request.getParameter("customerPASSWORD");
        
        boolean isValidLogin = customerLoginDao.loginCustomer(customerNAME, customerPASSWORD);

        // Create a Customer object with the provided username and password
        if (isValidLogin) {
            // Retrieve the customer details
            Customer customer = customerLoginDao.getCustomerDetails(customerNAME);

            // Set customer details as request attributes
            if (customer != null) {
                // Set customer details as request attributes
                request.setAttribute("customer", customer);

                // Forward the request to the userDetails.jsp file for displaying the details
                request.getRequestDispatcher("signinsuccess.jsp").forward(request, response);
            } else {
                // Handle the case when the customer details cannot be retrieved
                response.sendRedirect("errorsignin.jsp");
            }
        } else {
            // If the login is invalid, redirect back to the login page or display an error message
            response.sendRedirect("customerSignIn.jsp");
        }
    }
}
