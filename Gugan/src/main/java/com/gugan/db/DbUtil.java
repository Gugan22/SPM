package com.gugan.db;

import java.sql.SQLException;

import org.javalite.activejdbc.Base;

public class DbUtil {

	public static void openTransaction() throws SQLException {

		open();

		Base.connection().setAutoCommit(false);

		Base.openTransaction();

	}

	public static void open() {

		if (!Base.hasConnection()) {

			Base.open("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/mini_app", "root", "Password12@");

		}

	}

	public static void commitTransaction() {

		if (Base.hasConnection()) {

			Base.commitTransaction();

		}

	}

	public static void close() {

		if (Base.hasConnection()) {

			Base.close();

		}

	}

	public static void rollback() {

		if (Base.hasConnection()) {

			Base.rollbackTransaction();

		}

	}
}