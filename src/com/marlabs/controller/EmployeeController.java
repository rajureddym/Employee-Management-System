package com.marlabs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.marlabs.model.EmployeeVO;
import com.marlabs.service.EmployeeBO;
import com.marlabs.service.EmployeeBOImpl;

/**
 * @author srinivasa.challa This is My Web Service Controller
 */
@Path("/empcontroller")
public class EmployeeController {
	private EmployeeBO employeeBO;

	/**
	 * 
	 */
	public EmployeeController() {
		System.out.println("From EmployeeController");
		employeeBO = new EmployeeBOImpl();
	}

	/**
	 * @param departmentNumber
	 * @return List<EmployeeVO>
	 * @throws EMSException
	 * @throws EMSBusinessException
	 */
	@GET
	@Path("/emplist/{departmentNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeVO> getDepartmentEmployeesList(
			@PathParam("departmentNumber") final int departmentNumber)
			throws EMSException, EMSBusinessException {
		System.out.println("From Controller getDepartmentEmployeesList Method:"
				+ departmentNumber);
		List<EmployeeVO> deprtmentEmpList = null;
		deprtmentEmpList = employeeBO
				.getDepartmentEmployeesList(departmentNumber);
		return deprtmentEmpList;
	}

	/**
	 * @param empNumber
	 * @return EmployeeVO
	 * @throws EMSException
	 * @throws EMSBusinessException
	 */
	@GET
	@Path("/getemp/{empnumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeVO getEmployeeDetails(
			@PathParam("empnumber") final int empNumber) throws EMSException,
			EMSBusinessException {
		EmployeeVO valueObject = null;
		valueObject = employeeBO.getEmployeeDetails(empNumber);
		return valueObject;
	}

	/**
	 * @param valueObject
	 * @return String Message
	 */
	@Path("/saveEmployee1")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String registerEmployee(final EmployeeVO valueObject) {
		String message = "";
		System.out.println("From Controller registerEmployee Method:"
				+ valueObject);
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date empDOJ = null;
			System.out.println(valueObject.getEmpDoj());
			try {
				empDOJ = dateFormat.parse(valueObject.getEmpDoj());
			} catch (ParseException e) {
				throw new EMSBusinessException("Enter Date In Correct Format");
			}
			valueObject.setEmpDOJ(empDOJ);
			boolean registrationFlag = employeeBO.registerEmployee(valueObject);
			if (registrationFlag) {
				message = "Employee Record Registred Successfully";
			}
		} catch (EMSException e) {
			message = e.getMessage();
		} catch (EMSBusinessException e) {
			message = e.getMessage();
		}
		return message;
	}

	/**
	 * 
	 * @param empNumber
	 * @param empName
	 * @param empJob
	 * @param empBossCode
	 * @param empDoj
	 * @param empSalary
	 * @param empComm
	 * @param empDeptNumber
	 * @return String Message
	 */
	@Path("/saveEmployee")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String registerEmployee1(@FormParam("empNumber") int empNumber,
			@FormParam("empName") String empName,
			@FormParam("empJob") String empJob,
			@FormParam("empBossCode") int empBossCode,
			@FormParam("empDoj") String empDoj,
			@FormParam("empSalary") double empSalary,
			@FormParam("empComm") double empComm,
			@FormParam("empDeptNumber") int empDeptNumber) {
		String message = "";
		// 2018-01-07
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date empDOJ = null;
			System.out.println(empDoj);
			try {
				empDOJ = dateFormat.parse(empDoj);
			} catch (ParseException e) {
				throw new EMSBusinessException("Date Format Exception");
			}
			EmployeeVO valueObject = new EmployeeVO();
			valueObject.setEmpNumber(empNumber);
			valueObject.setEmpName(empName);
			valueObject.setEmpJob(empJob);
			valueObject.setEmpBossCode(empBossCode);
			valueObject.setEmpDOJ(empDOJ);
			valueObject.setEmpSalary(empSalary);
			valueObject.setEmpCommission(empComm);
			valueObject.setEmpDepartmentNumber(empDeptNumber);

			boolean registrationFlag = employeeBO.registerEmployee(valueObject);
			if (registrationFlag) {
				message = "Employee Record Registred Successfully";
			}
		} catch (EMSException e) {
			message = e.getMessage();
		} catch (EMSBusinessException e) {
			message = e.getMessage();
		}
		return message;
	}
}
