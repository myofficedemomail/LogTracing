package com.softtek.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softtek.form.ApplicationDtlsForm;

@Controller
public class AdminApplicationController {
	@GetMapping("/")
	public String loginPage(Model model) {
		// model.addAttribute("searchform", new SearchRequest());
		// model.addAttribute("list", null);
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
		// model.addAttribute("searchform", new SearchRequest());
		// model.addAttribute("list", null);
		// List<ServerDtlsDto> allServerDtls = serverService.getAllServerDtls();
		// model.addAttribute("allServiceDtls", allServerDtls);
		return "index";
	}

	/*
	 * @PostMapping("/addServer") public String savingServerDtls(@ModelAttribute
	 * ServerDtlsDto sreverDtlsDto,Model model) { String dtls =
	 * serverService.addServerDtls(sreverDtlsDto); model.addAttribute("msg",dtls);
	 * return "admin"; }
	 */
	@RequestMapping(value = "applicationDtls", method = RequestMethod.POST)
	public String application(@ModelAttribute ApplicationDtlsForm applicationDtlsForm, Model model) {
		model.addAttribute("app", new ApplicationDtlsForm());
		return "admin";
	}

	@RequestMapping(value = "saveApplicationDtls", method = RequestMethod.POST)
	public String addApplication(@ModelAttribute("app") ApplicationDtlsForm applicationDtlsForm) {
		System.out.println(applicationDtlsForm);
		return "";
	}
}
