package com.perf.hr.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.perf.hr.admin.domain.AdminModel;
import com.perf.hr.admin.service.AdminService;

@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping("/Login")
	public String Login(Model model) {
		model.addAttribute("admin", new AdminModel());
		return "index";
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("admin") @Validated AdminModel admin, BindingResult bindingResult,
			Model model) {
		String formResult;
		String email = admin.getAdminemail();

		boolean alReadyExists = adminService.findbyUserName(email);
		if (alReadyExists) {
			ObjectError error = new ObjectError("Field Error", "Email is already registered");
			bindingResult.addError(error);
		}

		if (!admin.getAdmin_password().equals(admin.getAdmin_status())) {
			ObjectError error = new ObjectError("Field Error", " Password and Confirm Password must be same");
			bindingResult.addError(error);
		}
		if (bindingResult.hasErrors()) {
			formResult = "index";
		} else {
			adminService.SaveAll(admin);
			formResult = "dashboard";
		}
		return formResult;

	}
}
