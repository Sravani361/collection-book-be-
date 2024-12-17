package com.example.sample_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Users",uniqueConstraints= {@UniqueConstraint(columnNames={"email"})})
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String firstname;
	
	@Column(nullable=false)
	private String lastname;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String phonenumber;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String dob;

	public void setFirstname(String firstname) {
		this.firstname=firstname;
	}

	public void setLastname(String lastname) {
		this.lastname=lastname;	
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber=phonenumber;	
	}

	public void setPassword(String password) {
		this.password=password;	
	}

	public void setDOB(String dob) {
		this.dob=dob;
	}

	public long getID() {
		return id;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getDob() {
		return dob;
	}

}
