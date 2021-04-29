package com.gugan.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gugan.cluster.ClusterUtil;
import com.gugan.http.Handler;


@Controller
public class ClusterController {
	@GetMapping("api/cluster")
	public void users(HttpServletResponse res) throws IOException {
		((Handler) () -> ClusterUtil.getAll()).handle(res);
	}
	
	@GetMapping("api/cluster/viewTeam")
	public void showTeam(@RequestParam String id, HttpServletResponse res ) throws IOException {
		((Handler)() -> ClusterUtil.showTeam(id)).handle(res);
	}
	
	@GetMapping("api/cluster/viewTeamMember")
	public void showTeamMemeber(@RequestParam String id, @RequestParam String teamName,HttpServletResponse res) throws IOException {
		((Handler)()-> ClusterUtil.showTeamMember(id, teamName) ).handle(res);;
	}

	@GetMapping("api/cluster/editTeam")
	public void editTeam(@RequestParam String id,@RequestParam String teamName, @RequestParam String oldTeamName,
			@RequestParam String teamLable, HttpServletResponse res) throws IOException
	{
		((Handler)() -> ClusterUtil.EditTeam(id, teamName, oldTeamName, teamLable)).handle(res);
	}
	
	@GetMapping("api/cluster/createTeam")
	public void editTeam(@RequestParam String id, @RequestParam String mId, @RequestParam String mName, @RequestParam String tName,
			@RequestParam String tLable,HttpServletResponse res ) throws IOException, SQLException {
		 ClusterUtil.creatTeam(mName, mId, tName, tLable, id);
		 res.getWriter().print("Sucess");
			
	}
}
