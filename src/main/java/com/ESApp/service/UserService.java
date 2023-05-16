package com.ESApp.service;

import java.util.ArrayList;
import java.util.List;

import com.ESApp.constant.ExpenceType;
import com.ESApp.entity.User;
import com.ESApp.vo.Expense;


public class UserService {

	public List<String> transations(String input) {
		//u1 1000 4 u1 u2 u3 u4 EQUAL
		Expense expense = new Expense();
		List<User> users = new ArrayList<>();
		List<Expense> expenseVo = new ArrayList<>();
		String[] in = input.split(" ");
		expense.setWhoPaid(in[0]);
		expense.setTotalAmount(Double.valueOf(in[1]));
		expense.setNoOfUsersParticipatedToPay(Integer.valueOf(in[2]));
		for (int i = 3; i < Integer.valueOf(in[1]) + i; i++) {
			users.add(new User(in[i]));
		}
		expense.setParticipants(users);
		for (int i = 0; i < in.length; i++) {
			if(ExpenceType.EQUAL.equals(in[i])) {
				expense.setExpenseType(in[in.length - 1]);
			}
			
		}
		
		
		return null;
	}

	public List<String> showBalances() {
		return null;
	}

}
