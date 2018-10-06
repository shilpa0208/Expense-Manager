package org.expense.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "expense_category")
public class ExpenseCategory implements Comparable<ExpenseCategory>{

	private String code;
	private String description;
	
	private Set<Expense> expenses = new HashSet<Expense>();
	
	public ExpenseCategory() {
		
	}
	
	@Id
	@Column(name = "code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Expense.class, mappedBy = "category")
	public Set<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return "ExpenseCategory [code=" + code + ", description=" + description + "]";
	}
	
	//Sorting all the ExpenseCategories in ascending order of Code 
	@Override
	public int compareTo(ExpenseCategory o) {
		return this.getCode().compareTo(o.getCode());
	}

	
	
}
