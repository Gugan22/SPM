package com.gugan.cluster;

import org.javalite.activejdbc.Model;

import com.gugan.model.User;

public class MemberProfileUtil extends Model{
	
	public static String MemberProfile(String id) {
		return User.where("company_id=?", id).toJson(false);
	}
}
