package net.system.model;

import java.io.Serializable;

public class Customer implements Serializable{
	private int customerID;
	private String customerNAME;
	private String customerPASSWORD;
	private String customerEMAIL;
	private int customerCONTACT;
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerNAME() {
		return customerNAME;
	}
	public void setCustomerNAME(String customerNAME) {
		this.customerNAME = customerNAME;
	}
	public String getCustomerPASSWORD() {
		return customerPASSWORD;
	}
	public void setCustomerPASSWORD(String customerPASSWORD) {
		this.customerPASSWORD = customerPASSWORD;
	}
	public String getCustomerEMAIL() {
		return customerEMAIL;
	}
	public void setCustomerEMAIL(String customerEMAIL) {
		this.customerEMAIL = customerEMAIL;
	}
	public int getCustomerCONTACT() {
		return customerCONTACT;
	}
	public void setCustomerCONTACT(int customerCONTACT) {
		this.customerCONTACT = customerCONTACT;
	}
	
}
