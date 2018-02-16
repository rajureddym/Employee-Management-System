package com.marlabs.controller;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author srinivasa.challa
 *
 */
@ApplicationPath("/rest")
public class MyApplication extends ResourceConfig {

	/**
	 * 
	 */
	public MyApplication() {
		packages("com.marlabs.controller");
		register(JacksonFeature.class);
		// register(MultiPartFeature.class);

	}
}