package net.system.web;

import java.io.IOException;
import java.util.List;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import net.system.dao.CustomerCRUDDao;
import net.system.model.Customer;

public class CustomerCRUDServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;
	private CustomerCRUDDao customerCRUDDao;

    public void init() {
        // Initialize the CustomerUpdateDao instance (you need to implement this class)
    	String JDBC_URL = getServletContext().getInitParameter("JDBC_URL");
    	String DB_USERNAME = getServletContext().getInitParameter("DB_USERNAME");
    	String DB_PASSWORD = getServletContext().getInitParameter("DB_PASSWORD");
    	
    	customerCRUDDao = new CustomerCRUDDao(JDBC_URL, DB_USERNAME, DB_PASSWORD);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertBook(request, response);
                break;
            case "/delete":
                deleteBook(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateBook(request, response);
                break;
            default:
            	listcustomer(request, response);
                break;
            }
        		} catch (SQLException ex) {
        			throw new ServletException(ex);
        	}
        }
      
        private void listcustomer(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            List<Customer> listcustomer = customerCRUDDao.listAllCustomers();
            request.setAttribute("listcustomer", listcustomer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerList.jsp");
            dispatcher.forward(request, response);
        }
        
        private void showNewForm(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerUpdateForm.jsp");
            dispatcher.forward(request, response);
        }
        private void showEditForm(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, ServletException, IOException {
            int customerID = Integer.parseInt(request.getParameter("customerID"));
            Customer existing_customer = customerCRUDDao.getCustomerDetails(customerID);
            RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerList.jsp");
            request.setAttribute("customer", existing_customer);
            dispatcher.forward(request, response);
     
        }
        private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException {
            String customerNAME = request.getParameter("customerNAME");
            String customerPASSWORD = request.getParameter("customerPASSWORD");
            String customerEMAIL = request.getParameter("customerEMAIL");
            int contact = Integer.parseInt(request.getParameter("customerCONTACT"));
            
            boolean storingcustomer = customerCRUDDao.insertCustomer(customerNAME,customerPASSWORD,customerEMAIL,);

            // Create a Customer object with the provided username and password
            
        }
    }
    

