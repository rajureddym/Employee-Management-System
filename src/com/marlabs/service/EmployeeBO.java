package com.marlabs.service;

import java.util.List;

import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.marlabs.model.EmployeeVO;

/**
 * @author srinivasa.challa This is Service Interface
 */
public interface EmployeeBO {

	/**
	 * @param valueObject
	 * @return boolean
	 * @throws EMSException
	 * @throws EMSBusinessException
	 */
	public boolean registerEmployee(final EmployeeVO valueObject)
			throws EMSException, EMSBusinessException;

	/**
	 * @param departmentNumber
	 * @return List<EmployeeVO>
	 * @throws EMSBusinessException
	 * @throws EMSException
	 */
	public abstract List<EmployeeVO> getDepartmentEmployeesList(
			final int departmentNumber) throws EMSBusinessException,
			EMSException;

	/**
	 * @param empNumber
	 * @return EmployeeVO
	 * @throws EMSException
	 * @throws EMSBusinessException
	 */
	public abstract EmployeeVO getEmployeeDetails(final int empNumber)
			throws EMSException, EMSBusinessException;
}
