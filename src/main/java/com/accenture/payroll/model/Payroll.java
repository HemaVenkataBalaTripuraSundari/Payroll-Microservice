package com.accenture.payroll.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Payroll")
public class Payroll {

	private Integer payrollId;
	public Integer getPayrollId() {
		return payrollId;
	}
	public void setPayrollId(Integer payrollId) {
		this.payrollId = payrollId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getRegisteredBank() {
		return registeredBank;
	}
	public void setRegisteredBank(String registeredBank) {
		this.registeredBank = registeredBank;
	}
	public double getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	@Id
	private int employeeId;
	private String registeredBank;
	private double accountNumber;
	private double monthlySalary;

	public Payroll() {
		super();
	}

	public Payroll(int payrollId,  String registeredBank, double monthlySalary,int employeeId,
			double accountNumber) {
		super();
		this.payrollId = payrollId;
		this.registeredBank = registeredBank;
		this.monthlySalary = monthlySalary;
		this.accountNumber = accountNumber;
		this.employeeId = employeeId;
	}

}
