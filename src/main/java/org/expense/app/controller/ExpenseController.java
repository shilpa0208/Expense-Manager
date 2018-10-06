package org.expense.app.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.expense.app.model.Expense;
import org.expense.app.model.ExpenseCategory;
import org.expense.app.model.Location;
import org.expense.app.model.PaymentType;
import org.expense.app.model.Sample;
import org.expense.app.model.User;
import org.expense.app.service.impl.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/expense")
public class ExpenseController {

	private static final String INDEX = "index";
	
	@Autowired
	private ExpenseService expenseService;
	
	
	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("template", "expenses");
		return INDEX;
	}
	
	@GetMapping("/users")
	public String users(Model model) {
		model.addAttribute("template", "users");
		//Sorting all the users
		Iterable<User> users = expenseService.findAllUsers();
		Collections.sort((List<User>) users);
		model.addAttribute("allUsers", users);
		//This is for adding a new User using modal
		model.addAttribute("user", new User());
		return INDEX;
	}
	
	@PostMapping("/users")
	public String addUser(@ModelAttribute(value="user") User user, Model model) {
		expenseService.saveUser(user);
		return "redirect:/expense/users";
	}
	
	@GetMapping("/users/{id}/edit")
	public String editUser(@PathVariable("id")int id, Model model) {
		model.addAttribute("template", "editUser");
		model.addAttribute("user", expenseService.findUserById(id));
		return INDEX;
	}
	
	@PostMapping("/users/{id}/update")
	public String updateUser(@PathVariable int id, @ModelAttribute(value="user") User user, @RequestParam(value="action", required=true)String action, Model model) {
		
		if(action.equals("save")) {
			expenseService.saveUser(user);
		}
		
		//User ID once deleted moves to the next in DB. Misses an ID
		if(action.equals("delete")) {
			expenseService.deleteUser(user);
		}
		
		//display users.html with all users
		return "redirect:/expense/users";
		
	}
	
	@GetMapping("/payment-types")
	public String paymentTypes(Model model) {
		model.addAttribute("template", "payment-types");
		//Sorting all payment types 
		Iterable<PaymentType> paymentTypes = expenseService.findAllPaymentTypes();
		Collections.sort((List<PaymentType>)paymentTypes);
		model.addAttribute("allPaymentTypes", paymentTypes);
		//This is for adding a new Payment Type using modal
		model.addAttribute("paymentType", new PaymentType());
		return INDEX;
	}
	
	@PostMapping("/payment-types")
	public String addPaymentType(@ModelAttribute(value="paymentType") PaymentType paymentType, Model model){
		expenseService.savePaymentType(paymentType);
		return "redirect:/expense/payment-types";
	}
	
	@GetMapping("/payment-types/{id}/edit")
	public String editPaymentType(@PathVariable("id") int id, Model model) {
		model.addAttribute("template", "editPaymentType");
		model.addAttribute("paymentType", expenseService.findPaymentTypeByID(id));
		return INDEX;
	}
	
	@PostMapping("/payment-types/{id}/update")
	public String updatePaymentType(@PathVariable int id, @ModelAttribute(value="paymentType") PaymentType paymentType, @RequestParam(value="action", required=true)String action, Model model) {
		
		if(action.equals("save")) {
			expenseService.savePaymentType(paymentType);
		}
		
		if(action.equals("delete")) {
			expenseService.deletePaymentType(paymentType);
		}
		
		//display users.html with all paymentTypes
		return "redirect:/expense/payment-types";
			
	}
	
	@GetMapping("/locations")
	public String locations(Model model) {
		model.addAttribute("template", "locations");
		//Sorting locations based on city in ascending order
		Iterable<Location> locations = expenseService.findAllLocations();
		Collections.sort((List<Location>)locations);
		model.addAttribute("allLocations", locations);
		//This is for adding a new location using the addLocationModel
		model.addAttribute("location", new Location());
		return INDEX;
	}
	
	@PostMapping("/locations")
	public String location(@ModelAttribute("location") Location location, Model model) {
		expenseService.saveLocation(location);
		return "redirect:/expense/locations";
	}

	
	@GetMapping("/locations/{id}/edit")
	public String editLocation(@PathVariable("id")Integer id, Model model) {
		model.addAttribute("template", "editLocation");
		model.addAttribute("location", expenseService.findLocationById(id));
		return INDEX;
	}
	
	@PostMapping("/locations/{id}/update")
	public String updateLocation(@PathVariable("id") Integer id, @ModelAttribute(value="location") Location location, @RequestParam(value="action", required=true)String action, Model model) {
		
		if(action.equals("save")) {
			expenseService.saveLocation(location);
		}
		
		if(action.equals("delete")) {
			expenseService.deleteLocation(location);
		}
		
		return "redirect:/expense/locations";
	}
	
	@GetMapping("/expense-category")
	public String expenseCategories(Model model) {
		model.addAttribute("template", "expense-category");
		//Sorting all ExpenseCategory based on Code in ascending order
		Iterable<ExpenseCategory> expenseCategories = expenseService.findAllExpenseCategories();
		Collections.sort((List<ExpenseCategory>)expenseCategories);
		model.addAttribute("allExpenseCategories", expenseCategories);
		//This is for adding a new ExpenseCategory
		model.addAttribute("expenseCategory", new ExpenseCategory());
		return INDEX;
	}
	
	@PostMapping("/expense-category")
	public String addExpenseCategory(@ModelAttribute("expense-category")ExpenseCategory expenseCategory, Model model) {
		expenseService.saveExpenseCategory(expenseCategory);
		return "redirect:/expense/expense-category";
	}
	
	
	@GetMapping("/expense-category/{code}/edit")
	public String editExpenseCategory(@PathVariable("code") String code, Model model) {
		model.addAttribute("template", "editExpenseCategory");
		model.addAttribute("expenseCategory", expenseService.findExpenseCategoryByCode(code));
		return INDEX;
	}
	
	@PostMapping("/expense-category/{code}/update")
	public String updateLocation(@PathVariable("code") String code, @ModelAttribute(value="expenseCategory") ExpenseCategory expenseCategory, @RequestParam(value="action", required=true)String action, Model model) {
		
		if(action.equals("save")) {
			expenseService.saveExpenseCategory(expenseCategory);
		}
		
		if(action.equals("delete")) {
			expenseService.deleteExpenseCategory(expenseCategory);
		}
	
		return "redirect:/expense/expense-category";
	}

	
	@GetMapping("/expenses")
	public String expenses(Model model) {
		model.addAttribute("template", "expenses");
		Iterable<Expense> expenses = expenseService.findAllExpenses();
		//Collections.sort((List<Expense>) expenses);
		model.addAttribute("allExpenses", expenses);
		model.addAttribute("expense", new Expense());
		model.addAttribute("allExpenseCategories", expenseService.findAllExpenseCategories());
		model.addAttribute("allPaymentTypes", expenseService.findAllPaymentTypes());
		model.addAttribute("allLocations", expenseService.findAllLocations());
		return INDEX;
	}
	@PostMapping("/expenses")
	public String addExpense(@ModelAttribute("expense")Expense expense, Model model) {
		expenseService.saveExpense(expense);
		return "redirect:/expense/expenses";
	}
	
	@GetMapping("/sample")
	public String createApp(Model model){
		model.addAttribute("sampleForm", new Sample());
		return "sample";
	}
	
	@PostMapping("/sample")
	public String createApp(@ModelAttribute("sampleForm") Sample sample, Model model){
		//expenseService.saveSample(sample);
		return "redirect:/expense/";
	}
		
}
