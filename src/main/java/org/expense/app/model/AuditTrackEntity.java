package org.expense.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class AuditTrackEntity {

	protected Date createdDate;
	protected User createdBy;
	protected Date updatedDate;
	protected User updatedBy;
	
	@PrePersist
	public void onPrePersist() {
		setCreatedDate(new Date());
		setCreatedBy(new User(1)); // TODO: remove this hardcoding
		setUpdatedDate(new Date());
		setUpdatedBy(new User(1)); // TODO: remove this hardcoding
	}
	
	@PreUpdate
	public void onPreUpdate() {
		setUpdatedDate(new Date());
		setUpdatedBy(new User(1)); // TODO: remove this hard coding
	}
	
	@Column(name = "date_created", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", referencedColumnName = "user_id", nullable = false)
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "date_updated", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by", referencedColumnName = "user_id", nullable = false)
	public User getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}
