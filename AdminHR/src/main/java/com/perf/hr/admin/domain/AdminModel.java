package com.perf.hr.admin.domain;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminModel {

	private int admin_id;
	@Email
	private String adminemail;
	@Size(min = 6, message="Enter at Least 6 characters")
	private String admin_password;
	private String admin_status;
	private Date admin_createddate;
	private Date admin_lastlogin;

}
