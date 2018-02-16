package com.ems.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author srinivasa.challa
 *
 */
@Provider
@SuppressWarnings("serial")
public class EMSBusinessException extends Exception implements
		ExceptionMapper<EMSBusinessException> {

	/**
	 * 
	 */
	public EMSBusinessException() {
		super();

	}

	/**
	 * @param message
	 */
	public EMSBusinessException(String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public EMSBusinessException(final Throwable cause) {
		super(cause);

	}

	@Override
	public Response toResponse(EMSBusinessException ex) {
		System.out.println("From toResponse Method");
		return Response.status(404).entity(ex.getMessage())
				.type(MediaType.APPLICATION_JSON).build();
	}

}
