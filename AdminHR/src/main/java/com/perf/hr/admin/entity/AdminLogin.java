package com.perf.hr.admin.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class AdminLogin {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int admin_id;
	
	@Column(name="admin_email")
	private String adminemail;
	
	@Column(name="admin_password")
	private String admin_password;
	
	@Column(name="admin_status")
	private String admin_status;
	
	@Column(name="admin_createddate")
	private Date admin_createddate;
	
	@Column(name="admin_lastlogin")
	private Date admin_lastlogin;

}
