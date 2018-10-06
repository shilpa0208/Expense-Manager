package org.expense.app.service.impl;

import org.expense.app.model.Expense;
import org.expense.app.model.ExpenseCategory;
import org.expense.app.model.Location;
import org.expense.app.model.PaymentType;
import org.expense.app.model.User;

public interface ExpenseService {

	public Iterable<User> findAllUsers();
	
	public User findUserById(Integer id);
	
	public User saveUser(User user);
	
	public void deleteUser(User user);
	
	public Iterable<PaymentType> findAllPaymentTypes();
	
	public PaymentType findPaymentTypeByID(Integer id);
	
	public PaymentType savePaymentType(PaymentType paymentType);
	
	public void deletePaymentType(PaymentType paymentType);
	
	public Iterable<Location> findAllLocations();
	
	public Location findLocationById(Integer id);
	
	public Location saveLocation(Location location);
	
	public void deleteLocation(Location location);
	
	public Iterable<ExpenseCategory> findAllExpenseCategories();
	
	public ExpenseCategory findExpenseCategoryByCode(String code);
	
	public ExpenseCategory saveExpenseCategory(ExpenseCategory expenseCategory);
	
	public void deleteExpenseCategory(ExpenseCategory expenseCategory);
	
	public Iterable<Expense> findAllExpenses();
	
	public Expense saveExpense(Expense expense);
	
}
