package com.kkd.customerloginservice;

public class CustomerLoginBean {
	private String mobileNo;
	private String password;
	
	protected CustomerLoginBean() {
		
	}
	public CustomerLoginBean(String mobileNo, String password) {
		super();
		this.mobileNo = mobileNo;
		this.password = password;
	}
	public String getmobileNo() {
		return mobileNo;
	}
	public void setmobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
