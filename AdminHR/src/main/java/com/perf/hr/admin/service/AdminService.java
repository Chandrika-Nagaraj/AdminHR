package com.perf.hr.admin.service;

import com.perf.hr.admin.domain.AdminModel;

public interface AdminService {

	public void SaveAll(AdminModel adminModel);

	public boolean findbyUserName(String username);

	public boolean getStatus(String email);

}
