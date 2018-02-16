package com.marlabs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ems.constants.SQLConstants;

/**
 * @author srinivasa.challa
 *
 */
public final class DBUtil {
	private DBUtil() {

	}

	/**
	 * @return connection
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(SQLConstants.DRIVER_CLASS_NAME);
			connection = DriverManager.getConnection(SQLConstants.DRIVER_URL,
					SQLConstants.DB_USER_NAME, SQLConstants.DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// LOG.fatal(e.getMessage()); Best Practice
		} catch (SQLException e) {
			e.printStackTrace();
			// LOG.fatal(e.getMessage()); Best Practice
		}
		return connection;
	}
}
