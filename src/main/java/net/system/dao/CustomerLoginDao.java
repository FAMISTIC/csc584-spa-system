package net.system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.system.model.Customer;

public class CustomerLoginDao {
	 private static final String JDBC_URL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
     private static final String DB_USERNAME = "root";
     private static final String DB_PASSWORD = "";
     
     public CustomerLoginDao() {
         try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }
     public boolean loginCustomer(String customerNAME, String customerPASSWORD) {
    	    	

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);

            // Step 2:Create a statement using connection object
        		PreparedStatement preparedStatement = connection.prepareStatement("select * from customers where customername = ? and customerpassword = ? ")) {
        	            preparedStatement.setString(1, customerNAME);
        	            preparedStatement.setString(2, customerPASSWORD);

        	            System.out.println(preparedStatement);
        	            ResultSet rs = preparedStatement.executeQuery();
        	            return rs.next();

        } catch (SQLException e) {
        	            // process sql exception
        	 printSQLException(e);
        }
        return false;
    }
    public Customer getCustomerDetails(String customerNAME) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "SELECT * FROM customers WHERE customerNAME = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerNAME);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(resultSet.getInt("customerID"));
                customer.setCustomerNAME(resultSet.getString("customerNAME"));
                customer.setCustomerPASSWORD(resultSet.getString("customerPASSWORD"));
                customer.setCustomerEMAIL(resultSet.getString("customerEMAIL"));
                customer.setCustomerCONTACT(resultSet.getInt("customerCONTACT"));
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}