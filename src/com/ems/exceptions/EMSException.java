package com.ems.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author srinivasa.challa
 *
 */
@Provider
@SuppressWarnings("serial")
public class EMSException extends Exception implements
		ExceptionMapper<EMSException> {

	/**
	 * 
	 */
	public EMSException() {
		super();

	}

	/**
	 * @param message
	 */
	public EMSException(final String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public EMSException(final Throwable cause) {
		super(cause);

	}

	@Override
	public Response toResponse(EMSException ex) {
		System.out.println("From toResponse Method");
		return Response.status(Status.NOT_FOUND).entity(ex.getMessage())
				.type(MediaType.APPLICATION_JSON).build();
	}

}
