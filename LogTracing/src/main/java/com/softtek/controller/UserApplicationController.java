package com.softtek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.softtek.service.AppService;

@Controller
public class UserApplicationController {
	@Autowired
	private AppService appService;
}
