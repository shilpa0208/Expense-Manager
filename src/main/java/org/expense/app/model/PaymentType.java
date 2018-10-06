package org.expense.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "payment_type")
public class PaymentType implements Comparable<PaymentType>{

	private Integer id;
	private String mode;
	private String type;
	
	private Set<Expense> expenses = new HashSet<>();
	
	public PaymentType() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pay_type_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "mode", nullable = false)
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Column(name = "type", nullable = true)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Expense.class, mappedBy = "paymentType")
	public Set<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return "PaymentType [mode=" + mode + ", type=" + type + "]";
	}

	//Sorting all the PaymentTypes based on Mode in ascending order
	@Override
	public int compareTo(PaymentType o) {
		return this.getMode().compareTo(o.getMode());
	}
	
}
