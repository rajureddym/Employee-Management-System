package com.marlabs.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.marlabs.model.EmployeeVO;
import com.marlabs.service.EmployeeBO;
import com.marlabs.service.EmployeeBOImpl;

/**
 * @author srinivasa.challa
 *
 */
public class EmployeeBOImplTest {
	private static EmployeeBO employeeBO;

	/**
	 * 
	 */
	@BeforeClass
	public static void init() {
		employeeBO = new EmployeeBOImpl();
	}

	/**
	 * 
	 */
	@AfterClass
	public static void destroy() {
		employeeBO = null;
	}

	/**
	 * 
	 */
	@Test
	public void testGetEmployeeDetails() {
		try {
			EmployeeVO valueObject = employeeBO.getEmployeeDetails(7839);
			System.out.println(valueObject);
			assertNotNull(valueObject);
		} catch (EMSException e) {
			fail();
		} catch (EMSBusinessException e) {
			fail();
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings({ "unused" })
	@Test
	public void testGetEmployeeDetails1() {
		try {
			EmployeeVO valueObject = employeeBO.getEmployeeDetails(1000);
		} catch (EMSException e) {
			fail();
		} catch (EMSBusinessException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings({ "deprecation" })
	@Test
	public void testGetEmployeeDetails11() {
		try {
			EmployeeVO originalObject = new EmployeeVO();
			originalObject.setEmpNumber(7839);
			originalObject.setEmpName("KING");
			originalObject.setEmpJob("PRESIDENT");
			originalObject.setEmpBossCode(0);
			originalObject.setEmpSalary(5000);
			originalObject.setEmpCommission(0);
			originalObject.setEmpDepartmentNumber(10);
			originalObject.setEmpDOJ(new Date(81, 10, 17));
			System.out.println(originalObject);
			EmployeeVO valueObject = employeeBO.getEmployeeDetails(7839);
			assertEquals(valueObject, originalObject);
			System.out.println("TestCase Pass");
		} catch (EMSException e) {
			fail();
		} catch (EMSBusinessException e) {
			fail();
		}
	}

	/**
	 * 
	 */
	@Test
	public void testGetDepartmentEmployeesList() {
		try {
			List<EmployeeVO> departmentEmpList = employeeBO
					.getDepartmentEmployeesList(10);
			int size = departmentEmpList.size();
			assertEquals(size, 6);
		} catch (EMSBusinessException e) {
			fail();
		} catch (EMSException e) {
			fail();
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings({ "unused" })
	@Test
	public void testGetDepartmentEmployeesList1() {
		try {
			List<EmployeeVO> departmentEmpList = employeeBO
					.getDepartmentEmployeesList(11);
		} catch (EMSBusinessException e) {
			System.err.println(e.getMessage());
		} catch (EMSException e) {
			fail();
		}
	}

}
