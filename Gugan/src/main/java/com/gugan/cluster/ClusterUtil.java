package com.gugan.cluster;

import java.sql.SQLException;

import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;

import com.gugan.db.DbUtil;
import com.gugan.model.Cluster;


public class ClusterUtil extends Model {
	public static String getAll() {
		return Cluster.findAll().toJson(false);
	}

	public static String showTeam(String id) {	
		
		LazyList<Model> findBySQL = Cluster.findBySQL("select *  FROM mini_app.clusters group by team_name,company_id having  company_id =?;", id);
		return findBySQL.toJson(false);
	}
	
	public static int EditTeam(String id, String TeamName, String oldeTeamName, String TeamLable) {
		return Cluster.update("team_name=?, team_lable=?", "company_id=? and team_lable=?", TeamName,TeamLable, id, TeamLable );
	}
	
	public static String showTeamMember (String id, String teamName){	
		
		LazyList<Model> findBySQL = Cluster.findBySQL("select *  FROM mini_app.clusters where company_id = ? having team_name=?;", id,teamName);
		return findBySQL.toJson(false);
	}
	
	public static String creatTeam(String memberName, String memberId, String teamname, String teamlable, String userId) throws SQLException {
		DbUtil.openTransaction();
		Cluster fineUser = new Cluster();
		boolean status = fineUser.set("company_id", userId, "team_member_name", memberName, "team_name", teamname, "member_company_id", memberId, 
				"team_lable", teamlable).insert();
		System.out.print(status);
		DbUtil.commitTransaction();
		DbUtil.close();
		return userId;
	}
}
