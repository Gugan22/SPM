package com.gugan.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gugan.cluster.MemberProfileUtil;
import com.gugan.http.Handler;

@Controller
public class MemberProfileController {

	@GetMapping("api/MemberProfile")
	public void memberProfile(@RequestParam String id, HttpServletResponse res) throws IOException {
		((Handler) () -> MemberProfileUtil.MemberProfile(id)).handle(res);
	}
}
