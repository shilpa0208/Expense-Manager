package org.expense.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sample")
public class Sample {

	private int id;
	private int sample1;
	private String sample2;
	private String sample3;
	private Date createdDate;
	
	public Sample() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "sample1")
	public int getSample1() {
		return sample1;
	}
	public void setSample1(int sample1) {
		this.sample1 = sample1;
	}
	
	@Column(name = "sample2")
	public String getSample2() {
		return sample2;
	}
	public void setSample2(String sample2) {
		this.sample2 = sample2;
	}
	
	@Column(name = "sample3")
	public String getSample3() {
		return sample3;
	}
	public void setSample3(String sample3) {
		this.sample3 = sample3;
	}
	
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
