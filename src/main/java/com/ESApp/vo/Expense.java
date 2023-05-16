package com.ESApp.vo;

import java.util.List;

import com.ESApp.entity.User;

public class Expense {

	private String whoPaid;
	private Double totalAmount;
	private Integer noOfUsersParticipatedToPay;
	private List<User> participants;
	private String expenseType;
	
	public String getWhoPaid() {
		return whoPaid;
	}
	public void setWhoPaid(String whoPaid) {
		this.whoPaid = whoPaid;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getNoOfUsersParticipatedToPay() {
		return noOfUsersParticipatedToPay;
	}
	public void setNoOfUsersParticipatedToPay(Integer noOfUsersParticipatedToPay) {
		this.noOfUsersParticipatedToPay = noOfUsersParticipatedToPay;
	}
	public List<User> getParticipants() {
		return participants;
	}
	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	
	
}
