package com.madx.mybatis.endpoints.interfaces;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Local
public interface ITime {

	@GET
	@Path("/")
	@Produces("application/json")
	public String now();
	
	@GET
	@Path("/ok")
	@Produces("application/json")
	public String ok();
	
	@GET
	@Path("/ko")
	@Produces("application/json")
	public String ko();

}