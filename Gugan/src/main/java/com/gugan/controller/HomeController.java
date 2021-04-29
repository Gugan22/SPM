package com.gugan.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gugan.http.Handler;
import com.gugan.user.UserUtil;

@Controller
public class HomeController {
	@GetMapping("api/users")
	public void users(HttpServletResponse res) throws IOException {
		((Handler) () -> UserUtil.getAll()).handle(res);
	}

	@GetMapping("api/users/verify")
	public static void validateUser(@RequestParam String userId, @RequestParam String passwordString,
			HttpServletResponse res) throws Exception {
		((Handler) () -> UserUtil.verify(userId, passwordString)).handle(res);
	}

	@GetMapping("api/users/find")
	public static void findUse(@RequestParam String userId, HttpServletResponse res) throws Exception {
		((Handler) () -> UserUtil.findUser(userId)).handle(res);
	}

	@GetMapping("api/users/regis")
	public static void newUser(@RequestParam String name, @RequestParam String id, @RequestParam String company,
			@RequestParam String mail, @RequestParam String mobile, @RequestParam String passwordString,
			HttpServletResponse res) throws Exception {

		UserUtil.newUserRegis(name, id, company, mail, mobile, passwordString);
		res.getWriter().print("Sucess");
	}

	@GetMapping("api/users/profileComp")
	public static void complProfile(@RequestParam String dob, @RequestParam String id, @RequestParam String location,
			@RequestParam String gender, @RequestParam String Company, HttpServletResponse res) throws SQLException {

		UserUtil.comptProfile(dob, id, location, gender, Company);
	}
}
