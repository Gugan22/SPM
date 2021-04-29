package com.gugan.prospects;

import org.javalite.activejdbc.Model;

import com.gugan.model.Prospect;

public class ProspectUtil extends Model {
	public static String getAll() {
		return Prospect.findAll().toJson(false);
	}
}
