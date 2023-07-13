package net.system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.system.model.Customer;

public class CustomerCRUDDao {

	 private  String JDBC_URL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
     private  String DB_USERNAME = "root";
     private  String DB_PASSWORD = "";
     private Connection jdbcConnection;
     
     public CustomerCRUDDao(String JDBC_URL, String DB_USERNAME, String DB_PASSWORD) {
         this.JDBC_URL = JDBC_URL;
         this.DB_USERNAME = DB_USERNAME;
         this.DB_PASSWORD = DB_PASSWORD;
     }
     
     protected void connect() throws SQLException {
         if (jdbcConnection == null || jdbcConnection.isClosed()) {
             try {
                 Class.forName("com.mysql.jdbc.Driver");
             } catch (ClassNotFoundException e) {
                 throw new SQLException(e);
             }
             jdbcConnection = DriverManager.getConnection(
            		 JDBC_URL, DB_USERNAME, DB_PASSWORD);
         }
     }
     
     protected void disconnect() throws SQLException {
         if (jdbcConnection != null && !jdbcConnection.isClosed()) {
             jdbcConnection.close();
         }
     }
     
     public boolean insertCustomer(Customer customer) throws SQLException {
         String sql = "INSERT INTO customer (customerNAME, customerPASSWORD, customerEMAIL, customerCONTACT) VALUES (?, ?, ?, ?)";
         connect();
          
         PreparedStatement statement = jdbcConnection.prepareStatement(sql);
         statement.setString(1, customer.getCustomerNAME());
         statement.setString(2, customer.getCustomerPASSWORD());
         statement.setString(3, customer.getCustomerEMAIL());
         statement.setInt(4, customer.getCustomerCONTACT());
          
         boolean rowInserted = statement.executeUpdate() > 0;
         statement.close();
         disconnect();
         return rowInserted;
     }
     
     public List<Customer> listAllCustomers() throws SQLException {
         List<Customer> listcustomer = new ArrayList<>();
          
         String sql = "SELECT * FROM customers";
          
         connect();
          
         Statement statement = jdbcConnection.createStatement();
         ResultSet resultSet = statement.executeQuery(sql);
          
         while (resultSet.next()) {
        	 Customer customer = new Customer();
             customer.setCustomerID(resultSet.getInt("customerID"));
             customer.setCustomerNAME(resultSet.getString("customerNAME"));
             customer.setCustomerPASSWORD(resultSet.getString("customerPASSWORD"));
             customer.setCustomerEMAIL(resultSet.getString("customerEMAIL"));
             customer.setCustomerCONTACT(resultSet.getInt("customerCONTACT"));
             listcustomer.add(customer);
        	 
        	
         }
          
         resultSet.close();
         statement.close();
          
         disconnect();
          
         return listcustomer;
     }
     public boolean deleteCustomer(Customer customer) throws SQLException {
         String sql = "DELETE FROM customers where customerID = ?";
          
         connect();
          
         PreparedStatement statement = jdbcConnection.prepareStatement(sql);
         statement.setInt(1, customer.getCustomerID());
          
         boolean rowDeleted = statement.executeUpdate() > 0;
         statement.close();
         disconnect();
         return rowDeleted;     
     }
     public boolean updateCustomer(Customer customer) throws SQLException {
         String sql = "UPDATE customers SET customerNAME = ?, customerPASSWORD = ?, customerEMAIL = ?, customerCONTACT = ?";
         sql += " WHERE customerID = ?";
         connect();
          
         PreparedStatement statement = jdbcConnection.prepareStatement(sql);
         statement.setString(1, customer.getCustomerNAME());
         statement.setString(2, customer.getCustomerPASSWORD());
         statement.setString(3, customer.getCustomerEMAIL());
         statement.setInt(4, customer.getCustomerCONTACT());
         statement.setInt(5, customer.getCustomerID());
          
         boolean rowUpdated = statement.executeUpdate() > 0;
         statement.close();
         disconnect();
         return rowUpdated;     
     }
     
     public Customer getCustomerDetails(int customerID) {
         try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD)) {
             String query = "SELECT * FROM customers WHERE customerID = ?";
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             preparedStatement.setInt(1, customerID);
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
}
