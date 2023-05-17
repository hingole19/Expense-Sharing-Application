package com.ESApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ESApp.constant.ExpenceType;
import com.ESApp.entity.User;
import com.ESApp.vo.Expense;

@Service
public class UserService {

	public List<String> transations(String input) {
		//u1 1000 4 u1 u2 u3 u4 EQUAL
		List<String> output = new ArrayList<>();
		User u = new User();
		Expense expense = splitInput(input);
	
		Double amountOwes = expense.getTotalAmount() / expense.getNoOfUsersParticipatedToPay();
		List<User> participants = expense.getParticipants();
		for (User user : participants) {
			if(!user.getName().equals("user1") || user.getName().equals("u1")) {
				output.add(String.valueOf(expense.getWhoPaid()) + ExpenceType.owes.name() + amountOwes);
			}
		}
		
		return output;
	}

	private Expense splitInput(String input) {
		Expense expense = new Expense();
		List<User> users = new ArrayList<>();
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
				expense.setExpenseType(in[i]);
			}
			if(ExpenceType.EXACT.equals(in[i])) {
				expense.setExpenseType(in[i]);
			}
		}
		return expense;
	}

	public List<String> showBalances() {
		return null;
	}

}
