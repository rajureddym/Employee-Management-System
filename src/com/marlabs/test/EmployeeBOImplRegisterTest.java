package com.marlabs.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
public class EmployeeBOImplRegisterTest {
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
	@SuppressWarnings("deprecation")
	@Test
	public void testRegisterEmployee() {
		try {
			EmployeeVO valueObject = new EmployeeVO();
			valueObject.setEmpNumber(2002);
			valueObject.setEmpName("SRINI");
			valueObject.setEmpJob("ANALYST");
			valueObject.setEmpBossCode(7839);
			valueObject.setEmpSalary(5000.00d);
			valueObject.setEmpCommission(2345.12d);
			valueObject.setEmpDepartmentNumber(20);
			java.util.Date doj = new java.util.Date(81, 02, 20);
			valueObject.setEmpDOJ(doj);
			boolean registrationFlag = employeeBO.registerEmployee(valueObject);
			assertEquals(registrationFlag, true);
		} catch (EMSException e) {
			fail();
		} catch (EMSBusinessException e) {
			fail();
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings({ "deprecation", "unused" })
	@Test(timeout = 300)
	public void testRegisterEmployee1() {
		try {
			EmployeeVO valueObject = new EmployeeVO();
			valueObject.setEmpNumber(2002);
			valueObject.setEmpName("SRINU");
			valueObject.setEmpJob("ANALYST");
			valueObject.setEmpBossCode(7839);
			valueObject.setEmpSalary(5000.00d);
			valueObject.setEmpCommission(2345.12d);
			valueObject.setEmpDepartmentNumber(20);
			java.util.Date doj = new java.util.Date(81, 02, 20);
			valueObject.setEmpDOJ(doj);
			boolean registrationFlag = employeeBO.registerEmployee(valueObject);
		} catch (EMSException e) {
			System.out.println(e.getMessage());
		} catch (EMSBusinessException e) {
			fail();
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings({ "deprecation", "unused" })
	@Test
	public void testRegisterEmployee2() {
		try {
			EmployeeVO valueObject = new EmployeeVO();
			valueObject.setEmpNumber(2003);
			valueObject.setEmpName("VASU@123");
			valueObject.setEmpJob("ANALYST");
			valueObject.setEmpBossCode(7839);
			valueObject.setEmpSalary(5000.00d);
			valueObject.setEmpCommission(2345.12d);
			valueObject.setEmpDepartmentNumber(20);
			java.util.Date doj = new java.util.Date(81, 02, 20);
			valueObject.setEmpDOJ(doj);
			boolean registrationFlag = employeeBO.registerEmployee(valueObject);
		} catch (EMSException e) {
			fail();
		} catch (EMSBusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings({ "deprecation", "unused" })
	@Test
	public void testRegisterEmployee3() {
		try {
			EmployeeVO valueObject = new EmployeeVO();
			valueObject.setEmpNumber(2004);
			valueObject.setEmpName("VASU");
			valueObject.setEmpJob("ANALYST@123");
			valueObject.setEmpBossCode(7839);
			valueObject.setEmpSalary(5000.00d);
			valueObject.setEmpCommission(2345.12d);
			valueObject.setEmpDepartmentNumber(20);
			java.util.Date doj = new java.util.Date(81, 02, 20);
			valueObject.setEmpDOJ(doj);
			boolean registrationFlag = employeeBO.registerEmployee(valueObject);
		} catch (EMSException e) {
			fail();
		} catch (EMSBusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings({ "deprecation", "unused" })
	@Test
	public void testRegisterEmployee4() {
		try {
			EmployeeVO valueObject = new EmployeeVO();
			valueObject.setEmpNumber(2005);
			valueObject.setEmpName("VASU");
			valueObject.setEmpJob("ANALYST");
			valueObject.setEmpBossCode(1000);
			valueObject.setEmpSalary(5000.00d);
			valueObject.setEmpCommission(2345.12d);
			valueObject.setEmpDepartmentNumber(20);
			java.util.Date doj = new java.util.Date(81, 02, 20);
			valueObject.setEmpDOJ(doj);
			boolean registrationFlag = employeeBO.registerEmployee(valueObject);
		} catch (EMSException e) {
			fail();
		} catch (EMSBusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings({ "unused" })
	@Test
	public void testRegisterEmployee5() {
		try {
			EmployeeVO valueObject = new EmployeeVO();
			boolean registrationFlag = employeeBO.registerEmployee(valueObject);
		} catch (EMSException e) {
			fail();
		} catch (EMSBusinessException e) {
			fail();
		} catch (NullPointerException e) {
			System.out.println("Exception:" + e.getMessage());
		}
	}

}
