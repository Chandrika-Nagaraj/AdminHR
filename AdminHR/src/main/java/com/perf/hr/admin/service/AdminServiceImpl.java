package com.perf.hr.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perf.hr.admin.domain.AdminModel;
import com.perf.hr.admin.entity.AdminLogin;
import com.perf.hr.admin.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository repository;

	AdminLogin adminLogin = new AdminLogin();

	public void SaveAll(AdminModel admijnModel) {
		admijnModel.setAdmin_status("UnApproved");
		java.util.Date today = new java.util.Date();
		admijnModel.setAdmin_createddate(new java.sql.Timestamp(today.getTime()));
		admijnModel.setAdmin_lastlogin(new java.sql.Timestamp(today.getTime()));
		BeanUtils.copyProperties(admijnModel, adminLogin);
		repository.save(adminLogin);
	}

	public boolean findbyUserName(String Username) {
		List<AdminLogin> adminEmail = repository.findByAdminemail(Username);
		boolean isExists = false;
		if (adminEmail.size() != 0) {
			isExists = true;
		}
		return isExists;
	}

	public boolean getStatus(String email) {
		List<AdminLogin> adminLogin = repository.findByAdminemailEquals(email);
		boolean isAdmin = true;
		if (adminLogin.size() == 1) {
			AdminLogin alogin = adminLogin.get(0);
			String status = alogin.getAdmin_status();
			isAdmin = (status.equals("0")) ? true : false;
		}
		return isAdmin;
	}
}
