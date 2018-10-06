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
import javax.persistence.Transient;

@Entity
@Table(name = "location")
public class Location implements Comparable<Location>{

	private static final String COUNTRY_INDIA = "INDIA";
	
	private Integer id;
	private String city;
	private String country;
	
	//Want to remove this - difficult to find it everytime
	private String zipCode;
	
	private Set<Expense> expenses = new HashSet<>();
	
	public Location() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "city", nullable = false)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "country", nullable = false)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(name = "zip_code", nullable = true)
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Expense.class, mappedBy="location")
	public Set<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	@Transient
	public boolean isIndia() {
		return getCountry().equals(COUNTRY_INDIA);
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", country=" + country + ", zipCode=" + zipCode + "]";
	}

	//To sort all the Location in ascending order of City
	@Override
	public int compareTo(Location o) {
		return this.getCity().compareTo(o.getCity());
	}
	
}
