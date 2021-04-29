package com.gugan.user;

import java.sql.SQLException;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;

import com.gugan.db.DbUtil;
import com.gugan.model.User;

public class UserUtil extends Model {

	public static String getAll() {
		return User.findAll().toJson(false);
	}

	public static String verify(String UserId, String Password) {
		return User.where("company_id=? and password=?", UserId, Password).toJson(false);
	}

	public static String findUser(String UserId) {
		return User.where("company_id=?", UserId).toJson(false);
	}

	public static String newUserRegis(String uName, String id, String company, String mail, String mobile, String pass)
			throws SQLException {

		DbUtil.openTransaction();
		User fineUser = new User();
		boolean status = fineUser.set("name", uName, "company_id", id, "company_name", company, "mail_id", mail,
				"mobile", mobile, "password", pass).insert();
		System.out.print(status);
		DbUtil.commitTransaction();
		DbUtil.close();
		return "Sucess";

	}

	public static int comptProfile(String Dob, String id, String location, String gender, String Company) throws SQLException {
		Base.open("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/mini_app", "root", "Password12@");
		return User.update("district=? , dob=?, gender=?, company_name=?", "company_id=?",location,Dob,gender, id);
	}
}
