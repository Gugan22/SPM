package com.gugan.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.gugan.db.DbUtil;

public interface Handler {
	Object method() throws IOException;

	default void handle(HttpServletResponse response) throws IOException {
		try (PrintWriter out = response.getWriter()) {
			DbUtil.open();
			out.print(method());
		} finally {
			DbUtil.close();
		}
	}

	default void handleTxn(HttpServletResponse res) throws IOException {
		try {
			DbUtil.openTransaction();
			method();
			DbUtil.commitTransaction();
		} catch (Exception e) {
			DbUtil.rollback();
		} finally {
			DbUtil.close();
		}
	}

}
