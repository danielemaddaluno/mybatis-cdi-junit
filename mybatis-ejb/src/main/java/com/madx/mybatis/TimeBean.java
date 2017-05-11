package com.madx.mybatis;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.mybatis.cdi.Transactional;

import com.madx.mybatis.data.mappers.TimeMapper;

/**
 *
 * @author madx
 */
@Stateless
@LocalBean
public class TimeBean {
    
	@Inject
	TimeMapper time;
	
	@Transactional
	public String now(){
		return time.now();
	}
	
	@Transactional
	public String normalRun(){
		String name = "A";
		time.addName(name);
		time.addName("B");
		return time.now();
	}
	
	@Transactional
	public String exceptionRun(){
		String name = "A";
		time.addName(name);
		time.addName("B");
		if(name.equals("A")) throw new NullPointerException();
		time.addName("C");
		return time.now();
	}
}
