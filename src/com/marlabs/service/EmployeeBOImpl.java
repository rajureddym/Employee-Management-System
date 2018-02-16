package com.marlabs.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ems.constants.ExceptionConstants;
import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.marlabs.dao.EmployeeDAO;
import com.marlabs.dao.EmployeeDAOImpl;
import com.marlabs.model.EmployeeVO;

/**
 * @author srinivasa.challa This is Service Layer Implementation Class
 */
public class EmployeeBOImpl implements EmployeeBO {
	private EmployeeDAO employeeDao;// HAS A RELATION

	/**
	 * Constructor
	 */
	public EmployeeBOImpl() {
		employeeDao = new EmployeeDAOImpl();
	}

	@Override
	public boolean registerEmployee(final EmployeeVO valueObject)
			throws EMSException, EMSBusinessException {
		String methodName = "registerEmployee()";

		System.out.println("Method Invoked From :" + this.getClass().getName()
				+ ":" + methodName + ":" + valueObject);
		boolean registrationFlag = false;
		// Data Validation Is Done

		if (validateAllBusinessConditions(valueObject)) {
			registrationFlag = employeeDao.registerEmployee(valueObject);

		}

		System.out.println("Response From The Method :"
				+ this.getClass().getName() + ":" + methodName + ":"
				+ registrationFlag);

		return registrationFlag;
	}

	private boolean validateAllBusinessConditions(final EmployeeVO valueObject)
			throws EMSBusinessException, EMSException {
		boolean validationsFlag = false;
		String methodName = "validateAllBusinessConditions";
		System.out.println("Method Invoked From :" + this.getClass().getName()
				+ ":" + methodName + ":" + valueObject);

		boolean result1 = validateEmpName(valueObject.getEmpName());
		boolean result2 = validateEmpJob(valueObject.getEmpJob());

		boolean bossCodeFlag = employeeDao.checkBossCodeExistance(valueObject
				.getEmpBossCode());
		if (!bossCodeFlag) {
			// throw new EMSBusinessException(
			// ErrorConstants.BOSS_CODE_NOT_FOUND_EXCEPTION);
			throw new EMSBusinessException("Boss Code Not Found");
		}
		if (result1 && result2 && bossCodeFlag) {
			validationsFlag = true;
		}

		return validationsFlag;
	}

	private boolean validateEmpName(final String empName)
			throws EMSBusinessException {
		boolean empNameFlag = false;
		String methodName = "validateEmpName()";

		System.out.println("Method Invoked From :" + this.getClass().getName()
				+ ":" + methodName + ":" + empName);

		String pattren = "^[a-zA-Z]+$";
		Pattern myPattren = Pattern.compile(pattren);
		Matcher matcher = myPattren.matcher(empName);
		if (!matcher.matches()) {
			// throw new
			// EMSBusinessException(ErrorConstants.EMP_NAME_VIOLATION);
			throw new EMSBusinessException("Emp Name Violation Error");
		} else {
			empNameFlag = true;
		}
		System.out.println("Response From The Method :"
				+ this.getClass().getName() + ":" + methodName + ":"
				+ empNameFlag);

		return empNameFlag;
	}

	private boolean validateEmpJob(final String empJob)
			throws EMSBusinessException {
		boolean empJobFlag = false;
		String methodName = "validateEmpJob()";

		System.out.println("Method Invoked From :" + this.getClass().getName()
				+ ":" + methodName + ":" + empJob);

		String pattren = "^[a-zA-Z]+$";
		Pattern myPattren = Pattern.compile(pattren);
		Matcher matcher = myPattren.matcher(empJob);
		if (!matcher.matches()) {
			// throw new EMSBusinessException(ErrorConstants.EMP_JOB_VIOLATION);
			throw new EMSBusinessException("Job Validation Error");
		} else {
			empJobFlag = true;
		}

		System.out.println("Response From The Method :"
				+ this.getClass().getName() + ":" + methodName + ":"
				+ empJobFlag);

		return empJobFlag;
	}

	@Override
	public List<EmployeeVO> getDepartmentEmployeesList(
			final int departmentNumber) throws EMSException,
			EMSBusinessException {
		final String METHOD_NAME = "getDepartmentEmployeesList";
		System.out.println("Method Invoked From BO:" + METHOD_NAME + ":"
				+ departmentNumber);
		List<EmployeeVO> departmentEmpList = employeeDao
				.getDepartmentEmployeesList(departmentNumber);
		if (departmentEmpList.isEmpty()) {
			throw new EMSBusinessException(
					ExceptionConstants.NO_EMPLOYEES_FOUND);
		}
		System.out.println("Response From The BO Method:" + METHOD_NAME + ":"
				+ departmentNumber);
		return departmentEmpList;
	}

	@Override
	public EmployeeVO getEmployeeDetails(final int empNumber)
			throws EMSException, EMSBusinessException {
		final String METHOD_NAME = "getEmployeeDetails";
		System.out.println("Method Invoked From BO:" + METHOD_NAME + ":"
				+ empNumber);
		EmployeeVO valueObject = employeeDao.getEmployeeDetails(empNumber);
		if (valueObject == null) {
			throw new EMSBusinessException(ExceptionConstants.NO_EMPLOYEE_FOUND);
		}
		System.out.println("Response From The BO Method:" + METHOD_NAME + ":"
				+ valueObject);
		return valueObject;
	}
}
