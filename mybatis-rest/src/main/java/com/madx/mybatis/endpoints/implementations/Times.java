package com.madx.mybatis.endpoints.implementations;

import javax.ejb.EJB;
import javax.ws.rs.Path;

import com.madx.mybatis.TimeBean;
import com.madx.mybatis.endpoints.interfaces.ITime;

@Path("/time")
public class Times implements ITime{
	
	@EJB
	private TimeBean timeService;

	@Override
	public String now() {
		return timeService.now();
	}

	@Override
	public String ok() {
		return timeService.normalRun();
	}

	@Override
	public String ko() {
		return timeService.exceptionRun();
	}
}