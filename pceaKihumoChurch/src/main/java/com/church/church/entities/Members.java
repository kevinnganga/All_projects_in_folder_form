package com.church.church.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Members {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@NotBlank(message = "District is mandatory")
	private String district;
	@NotBlank(message = "Serving position is mandatory")
	private String serving_position;
	@NotBlank(message = "Full member is mandatory")
	private String full_member;
	@NotBlank(message = "Phone is mandatory")
	private String phone;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date membership_date;
	
	
	public Members() {
		
	}


	public Members(long id, @NotBlank(message = "Name is mandatory") String name,
			@NotBlank(message = "District is mandatory") String district,
			@NotBlank(message = "Serving position is mandatory") String serving_position,
			@NotBlank(message = "Full member is mandatory") String full_member,
			@NotBlank(message = "Phone is mandatory") String phone, Date membership_date) {
		super();
		this.id = id;
		this.name = name;
		this.district = district;
		this.serving_position = serving_position;
		this.full_member = full_member;
		this.phone = phone;
		this.membership_date = membership_date;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getServing_position() {
		return serving_position;
	}


	public void setServing_position(String serving_position) {
		this.serving_position = serving_position;
	}


	public String getFull_member() {
		return full_member;
	}


	public void setFull_member(String full_member) {
		this.full_member = full_member;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public java.util.Date getMembership_date() {
		return membership_date;
	}


	public void setMembership_date(java.util.Date membership_date) {
		this.membership_date = membership_date;
	}


	@Override
	public String toString() {
		return "Members [id=" + id + ", name=" + name + ", district=" + district + ", serving_position="
				+ serving_position + ", full_member=" + full_member + ", phone=" + phone + ", membership_date="
				+ membership_date + "]";
	}
	
	


	
	
	
	

	
}
