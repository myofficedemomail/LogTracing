package com.softtek.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softtek.form.ApplicationDtlsForm;
import com.softtek.service.AppService;

@Controller
public class AdminApplicationController {
	@Autowired
	private AppService appService;

	@GetMapping("/")
	public String loginPage(Model model) {
		return "login";
	}

	@PostMapping("/login")
	public String reportPage(Model model, HttpServletRequest request) {
		Object username = request.getParameter("username");
		Object password = request.getParameter("password");
		if (username != null && password != null) {
			if (username.toString().equals("admin") && password.toString().equals("admin")) {
				model.addAttribute("app", new ApplicationDtlsForm());
				return "admin";
			}
		}
		List<ApplicationDtlsForm> listAppDtls = appService.listApplicationDtlsForm();
		model.addAttribute("listAppDtls", listAppDtls);
		return "index";
	}

	@RequestMapping(value = "applicationDtls", method = RequestMethod.POST)
	public String application(@ModelAttribute ApplicationDtlsForm applicationDtlsForm, Model model) {
		model.addAttribute("app", new ApplicationDtlsForm());
		return "admin";
	}

	@RequestMapping(value = "saveApplicationDtls", method = RequestMethod.POST)
	public String addApplication(@ModelAttribute("app") ApplicationDtlsForm applicationDtlsForm, Model model)
			throws Exception {
		System.out.println(applicationDtlsForm);
		boolean flag = appService.saveAppDtls(applicationDtlsForm);
		if (!flag) {
			model.addAttribute("err", "Unable To Save Server Details");
		} else {
			model.addAttribute("info", "Successfully Added Server Details");
		}
		return "admin";
	}
}
