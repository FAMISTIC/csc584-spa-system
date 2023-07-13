package net.system.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import net.system.dao.CustomerRegisterDao;
import net.system.model.Customer;

@WebServlet("/signup")
public class CustomerRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerRegisterDao customerRegisterDao;

    public void init() {
        customerRegisterDao = new CustomerRegisterDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String customerNAME = request.getParameter("customerNAME");
        String customerEMAIL = request.getParameter("customerEMAIL");
        String customerPASSWORD = request.getParameter("customerPASSWORD");
        int customerCONTACT = Integer.parseInt(request.getParameter("customerCONTACT"));

        Customer customer = new Customer();
        customer.setCustomerNAME(customerNAME);
        customer.setCustomerEMAIL(customerEMAIL);
        customer.setCustomerCONTACT(customerCONTACT);
        customer.setCustomerPASSWORD(customerPASSWORD);
        
        request.setAttribute("customerNAME", customerNAME);
        request.setAttribute("customerEMAIL", customerEMAIL);
        request.setAttribute("customerCONTACT", customerCONTACT);
        request.setAttribute("customerPASSWORD", customerPASSWORD);
        
        System.out.println("Data : " + customer);
        try {
            customerRegisterDao.registerCustomer(customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response); 
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}