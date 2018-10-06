package org.expense.app.service.impl;

import org.expense.app.model.Expense;
import org.expense.app.model.ExpenseCategory;
import org.expense.app.model.Location;
import org.expense.app.model.PaymentType;
import org.expense.app.model.User;
import org.expense.app.repository.ExpenseCategoryRepository;
import org.expense.app.repository.ExpenseRepository;
import org.expense.app.repository.LocationRepository;
import org.expense.app.repository.PaymentTypeRepository;
import org.expense.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PaymentTypeRepository paymentTypeRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private ExpenseCategoryRepository expenseCategoryRepository;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Override
	public Iterable<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public User findUserById(Integer id) {
		return userRepository.findOne(id);
	}
	
	@Override
	//Updated the user information
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	@Override
	public Iterable<PaymentType> findAllPaymentTypes() {
		return paymentTypeRepository.findAll();
	}
	
	@Override
	public PaymentType findPaymentTypeByID(Integer id) {
		return paymentTypeRepository.findOne(id);
	}
	
	@Override
	public PaymentType savePaymentType(PaymentType paymentType) {
		return paymentTypeRepository.save(paymentType);
	}
	
	@Override
	public void deletePaymentType(PaymentType paymentType) {
		paymentTypeRepository.delete(paymentType);
	}
	
	@Override
	public Iterable<Location> findAllLocations(){
		return locationRepository.findAll();
	}
	
	@Override
	public Location findLocationById(Integer id) {
		return locationRepository.findOne(id);
	}
	
	@Override
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		locationRepository.delete(location);		
	}
	
	@Override
	public Iterable<ExpenseCategory> findAllExpenseCategories() {
		return expenseCategoryRepository.findAll();
	}

	@Override
	public ExpenseCategory findExpenseCategoryByCode(String code) {
		return expenseCategoryRepository.findExpenseCategoryByCode(code);
	}

	@Override
	public ExpenseCategory saveExpenseCategory(ExpenseCategory expenseCategory) {
		return expenseCategoryRepository.save(expenseCategory);
	}

	@Override
	public void deleteExpenseCategory(ExpenseCategory expenseCategory) {
		expenseCategoryRepository.delete(expenseCategory);
	}

	@Override
	public Iterable<Expense> findAllExpenses() {
		return expenseRepository.findAll();
	}

	@Override
	public Expense saveExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	

	

}
