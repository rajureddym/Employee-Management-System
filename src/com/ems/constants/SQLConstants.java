package com.ems.constants;

/**
 * @author srinivasa.challa
 *
 */
public final class SQLConstants {

	private SQLConstants() {

	}

	/**
	 * BOSS_CODE_CHECK_QUERY
	 */
	public static final String BOSS_CODE_CHECK_QUERY = "SELECT empno FROM emp WHERE empno=?";
	/**
	 * Employee Insert Query
	 */
	public static final String EMP_INSERT_QUERY = "INSERT INTO emp VALUES(?,?,?,?,?,?,?,?)";
	/**
	 * DB URL
	 */
	public static final String DRIVER_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	/**
	 * DB User Name
	 */
	public static final String DB_USER_NAME = "System";

	/**
	 * DB Password
	 */
	public static final String DB_PASSWORD = "Root";
	/**
	 * Driver Class Name
	 */
	public static final String DRIVER_CLASS_NAME = "oracle.jdbc.driver.OracleDriver";
	/**
	 * Used to return Employee's who are all working for a Particular Department
	 */
	public static final String DEPT_EMP_SELECT_QUERY = "SELECT * FROM emp WHERE dno=?";

	/**
	 * Employee Find Query
	 */
	public static final String EMP_FIND_QUERY = "SELECT * FROM emp WHERE empno=?";
}
