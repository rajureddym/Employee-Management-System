package com.marlabs.dao;

import java.util.List;

import com.ems.exceptions.EMSException;
import com.marlabs.model.EmployeeVO;

/**
 * @author srinivasa.challa This is DAO Interface
 */
public interface EmployeeDAO {
	/**
	 * @param valueObject
	 * @return boolean
	 * @throws EMSException
	 */
	public boolean registerEmployee(final EmployeeVO valueObject)
			throws EMSException;

	/**
	 * @param departmentNumber
	 * @return List<EmployeeVO>
	 * @throws EMSException
	 */
	public abstract List<EmployeeVO> getDepartmentEmployeesList(
			final int departmentNumber) throws EMSException;

	/**
	 * @param empNumber
	 * @return EmployeeVO
	 * @throws EMSException
	 */
	public abstract EmployeeVO getEmployeeDetails(final int empNumber)
			throws EMSException;

	/**
	 * @param empBossCode
	 * @return boolean
	 * @throws EMSException
	 */
	public boolean checkBossCodeExistance(final int empBossCode)
			throws EMSException;
}
