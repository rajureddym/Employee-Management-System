package com.marlabs.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author srinivasa.challa
 *
 */
@SuppressWarnings("serial")
// @XmlRootElement(name = "employeevo")
public class EmployeeVO implements Serializable {
	private int empNumber;
	private String empName;
	private String empJob;
	private int empBossCode;
	private Date empDOJ;
	private double empSalary;
	private double empCommission;
	private int empDepartmentNumber;

	private String empDoj;

	/**
	 * @return the empDoj
	 */
	public String getEmpDoj() {
		return empDoj;
	}

	/**
	 * @param empDoj
	 *            the empDoj to set
	 */
	public void setEmpDoj(String empDoj) {
		this.empDoj = empDoj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeVO [empNumber=" + empNumber + ", empName=" + empName
				+ ", empJob=" + empJob + ", empBossCode=" + empBossCode
				+ ", empDOJ=" + empDOJ + ", empSalary=" + empSalary
				+ ", empCommission=" + empCommission + ", empDepartmentNumber="
				+ empDepartmentNumber + "]";
	}

	/**
	 * @return the empNumber
	 */
	public int getEmpNumber() {
		return empNumber;
	}

	/**
	 * @param empNumber
	 *            the empNumber to set
	 */
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName
	 *            the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empJob
	 */
	public String getEmpJob() {
		return empJob;
	}

	/**
	 * @param empJob
	 *            the empJob to set
	 */
	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	/**
	 * @return the empBossCode
	 */
	public int getEmpBossCode() {
		return empBossCode;
	}

	/**
	 * @param empBossCode
	 *            the empBossCode to set
	 */
	public void setEmpBossCode(int empBossCode) {
		this.empBossCode = empBossCode;
	}

	/**
	 * @return the empDOJ
	 */
	public Date getEmpDOJ() {
		return empDOJ;
	}

	/**
	 * @param empDOJ
	 *            the empDOJ to set
	 */
	public void setEmpDOJ(Date empDOJ) {
		this.empDOJ = empDOJ;
	}

	/**
	 * @return the empSalary
	 */
	public double getEmpSalary() {
		return empSalary;
	}

	/**
	 * @param empSalary
	 *            the empSalary to set
	 */
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	/**
	 * @return the empCommission
	 */
	public double getEmpCommission() {
		return empCommission;
	}

	/**
	 * @param empCommission
	 *            the empCommission to set
	 */
	public void setEmpCommission(double empCommission) {
		this.empCommission = empCommission;
	}

	/**
	 * @return the empDepartmentNumber
	 */
	public int getEmpDepartmentNumber() {
		return empDepartmentNumber;
	}

	/**
	 * @param empDepartmentNumber
	 *            the empDepartmentNumber to set
	 */
	public void setEmpDepartmentNumber(int empDepartmentNumber) {
		this.empDepartmentNumber = empDepartmentNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empBossCode;
		long temp;
		temp = Double.doubleToLongBits(empCommission);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((empDOJ == null) ? 0 : empDOJ.hashCode());
		result = prime * result + empDepartmentNumber;
		result = prime * result + ((empJob == null) ? 0 : empJob.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + empNumber;
		temp = Double.doubleToLongBits(empSalary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeVO other = (EmployeeVO) obj;
		if (empBossCode != other.empBossCode)
			return false;
		if (Double.doubleToLongBits(empCommission) != Double
				.doubleToLongBits(other.empCommission))
			return false;
		if (empDOJ == null) {
			if (other.empDOJ != null)
				return false;
		} else if (!empDOJ.equals(other.empDOJ))
			return false;
		if (empDepartmentNumber != other.empDepartmentNumber)
			return false;
		if (empJob == null) {
			if (other.empJob != null)
				return false;
		} else if (!empJob.equals(other.empJob))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (empNumber != other.empNumber)
			return false;
		if (Double.doubleToLongBits(empSalary) != Double
				.doubleToLongBits(other.empSalary))
			return false;
		return true;
	}
}
