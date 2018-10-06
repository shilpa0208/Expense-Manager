package org.expense.app.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "expense")
public class Expense extends AuditTrackEntity{

	private Integer id;
	private ExpenseCategory category;
	private PaymentType paymentType;
	private Location location;
	private String description;
	private BigDecimal amount;
	
	public Expense() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_code", referencedColumnName = "code", nullable = false)
	public ExpenseCategory getCategory() {
		return category;
	}

	public void setCategory(ExpenseCategory category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pay_type_id", referencedColumnName = "pay_type_id", nullable = false)
	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", referencedColumnName = "location_id", nullable = false)
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "amount", nullable = false)
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", category=" + category.getCode() + ", paymentType=" + paymentType.getMode() + ", location="
				+ location.getCity() + ", description=" + description + ", amount=" + amount + "]";
	}
	
}
