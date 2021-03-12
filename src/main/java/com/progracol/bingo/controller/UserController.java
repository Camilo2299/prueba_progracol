package com.progracol.bingo.controller;

import com.progracol.bingo.Models.entity.UserEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class UserController {

	@GetMapping({ "/auth/login" })
	public String login(Model model) {
		model.addAttribute("usuario", new UserEntity());
		return "login";
	}

}