package com.gugan.store;

import org.javalite.activejdbc.Model;

import com.gugan.model.Store;

public class StoreUtil extends Model {
	public static String getAll() {
		return Store.findAll().toJson(false);
	}
}
