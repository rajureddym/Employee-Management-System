package com.marlabs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ems.constants.SQLConstants;
import com.ems.exceptions.EMSException;
import com.marlabs.model.EmployeeVO;
import com.marlabs.util.DBUtil;

/**
 * @author srinivasa.challa This Class Is DAO Layer Implementation
 */
public class EmployeeDAOImpl implements EmployeeDAO {
	@Override
	public boolean registerEmployee(final EmployeeVO valueObject)
			throws EMSException {
		final String methodName = "registerEmployee()";

		System.out.println("Method Invoked From :" + this.getClass().getName()
				+ ":" + methodName + ":" + valueObject);

		boolean registrationFlag = false;
		Connection connection = null;
		PreparedStatement pstStatement = null;
		try {
			connection = DBUtil.getConnection();

			pstStatement = connection
					.prepareStatement(SQLConstants.EMP_INSERT_QUERY);
			pstStatement.setInt(1, valueObject.getEmpNumber());
			pstStatement.setString(2, valueObject.getEmpName());
			pstStatement.setString(3, valueObject.getEmpJob());
			pstStatement.setInt(4, valueObject.getEmpBossCode());
			long timeValue = valueObject.getEmpDOJ().getTime();
			pstStatement.setDate(5, new java.sql.Date(timeValue));
			pstStatement.setDouble(6, valueObject.getEmpSalary());
			pstStatement.setDouble(7, valueObject.getEmpCommission());
			pstStatement.setInt(8, valueObject.getEmpDepartmentNumber());
			int updateCount = pstStatement.executeUpdate();
			if (updateCount > 0) {
				registrationFlag = true;
			}
		} catch (SQLException e) {
			throw new EMSException(e);
		} finally {
			try {
				if (pstStatement != null) {
					pstStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				// LOG.fatal(ErrorConstants.RESOURCE_CLOSING_EXCEPTION);
			}
		}
		System.out.println("Response From The Method :"
				+ this.getClass().getName() + ":" + methodName + ":"
				+ registrationFlag);
		return registrationFlag;
	}

	@Override
	public boolean checkBossCodeExistance(final int bossCode)
			throws EMSException {
		boolean bossCodeFlag = false;
		final String methodName = "checkBossCodeExistance()";

		System.out.println("Method Invoked From :" + this.getClass().getName()
				+ ":" + methodName + ":" + bossCode);

		Connection connection = null;
		PreparedStatement pstStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			pstStatement = connection
					.prepareStatement(SQLConstants.BOSS_CODE_CHECK_QUERY);
			pstStatement.setInt(1, bossCode);
			resultSet = pstStatement.executeQuery();
			if (resultSet.next()) {
				bossCodeFlag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EMSException(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (pstStatement != null) {
					pstStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e2) {
				e2.printStackTrace();
				/*
				 * throw new EMSException(
				 * ErrorConstants.RESOURCE_CLOSING_EXCEPTION);
				 */
				// LOG.fatal(ErrorConstants.RESOURCE_CLOSING_EXCEPTION);
			}
		}

		System.out.println("Response From The Method :"
				+ this.getClass().getName() + ":" + methodName + ":"
				+ bossCodeFlag);

		return bossCodeFlag;

	}

	@Override
	public List<EmployeeVO> getDepartmentEmployeesList(
			final int departmentNumber) throws EMSException {
		final String METHOD_NAME = "getDepartmentEmployeesList";
		System.out.println("Method Invoked From DAO:" + METHOD_NAME + ":"
				+ departmentNumber);
		Connection connection = null;
		PreparedStatement pstStatement = null;
		ResultSet resultSet = null;
		List<EmployeeVO> departmentEmpList = new ArrayList<EmployeeVO>();
		try {
			connection = DBUtil.getConnection();
			pstStatement = connection
					.prepareStatement(SQLConstants.DEPT_EMP_SELECT_QUERY);
			pstStatement.setInt(1, departmentNumber);
			resultSet = pstStatement.executeQuery();

			while (resultSet.next()) {
				EmployeeVO valueObject = new EmployeeVO();
				valueObject.setEmpNumber(resultSet.getInt(1));
				valueObject.setEmpName(resultSet.getString(2));
				valueObject.setEmpJob(resultSet.getString(3));
				valueObject.setEmpBossCode(resultSet.getInt(4));
				valueObject.setEmpDOJ(resultSet.getDate(5));
				valueObject.setEmpSalary(resultSet.getDouble(6));
				valueObject.setEmpCommission(resultSet.getDouble(7));
				valueObject.setEmpDepartmentNumber(resultSet.getInt(8));
				departmentEmpList.add(valueObject);
			}

		} catch (SQLException e) {
			throw new EMSException(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (pstStatement != null) {
					pstStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				// throw new EMSException(e);
				// LOG.fatal(e.getMessage()); Best Practice
			}
		}
		System.out.println("Response From The DAO Method:" + METHOD_NAME + ":"
				+ departmentEmpList);
		return departmentEmpList;
	}

	@Override
	public EmployeeVO getEmployeeDetails(final int empNumber)
			throws EMSException {
		final String METHOD_NAME = "getEmployeeDetails";
		System.out.println("Method Invoked From DAO:" + METHOD_NAME + ":"
				+ empNumber);
		Connection connection = null;
		PreparedStatement pstStatement = null;
		ResultSet resultSet = null;
		EmployeeVO valueObject = null;
		try {
			connection = DBUtil.getConnection();
			pstStatement = connection
					.prepareStatement(SQLConstants.EMP_FIND_QUERY);
			pstStatement.setInt(1, empNumber);
			resultSet = pstStatement.executeQuery();
			if (resultSet.next()) {
				valueObject = new EmployeeVO();
				valueObject.setEmpNumber(resultSet.getInt(1));
				valueObject.setEmpName(resultSet.getString(2));
				valueObject.setEmpJob(resultSet.getString(3));
				valueObject.setEmpBossCode(resultSet.getInt(4));
				valueObject.setEmpDOJ(resultSet.getDate(5));
				valueObject.setEmpSalary(resultSet.getDouble(6));
				valueObject.setEmpCommission(resultSet.getDouble(7));
				valueObject.setEmpDepartmentNumber(resultSet.getInt(8));
			}
		} catch (SQLException e) {
			throw new EMSException(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (pstStatement != null) {
					pstStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// LOG.fatal(e.getMessage()); Best Practice
			}
		}
		System.out.println("Response From The DAO Method:" + METHOD_NAME + ":"
				+ valueObject);
		return valueObject;
	}

}
