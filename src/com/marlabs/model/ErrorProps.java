package com.marlabs.model;

/**
 * @author srinivasa.challa
 *
 */
public class ErrorProps {
	private String status;
	private String errorMessage;

	/**
	 * 
	 */
	public ErrorProps() {
	}

	/**
	 * @param statusFromOutside
	 * @param errorMessageFromOutside
	 */
	public ErrorProps(String statusFromOutside, String errorMessageFromOutside) {
		this.status = statusFromOutside;
		this.errorMessage = errorMessageFromOutside;
	}

	/**
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 */
	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
