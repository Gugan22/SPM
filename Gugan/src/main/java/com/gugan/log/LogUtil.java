package com.gugan.log;

import org.javalite.activejdbc.Model;

import com.gugan.model.Log;

public class LogUtil extends Model {
	public static String getAll() {
		return Log.findAll().toJson(false);
	}
}
