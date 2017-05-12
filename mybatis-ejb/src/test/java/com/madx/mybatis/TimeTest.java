package com.madx.mybatis;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.cdi.Transactional;

import com.madx.mybatis.data.mappers.TimeMapper;

@RunWith(WeldJUnit4Runner.class) 
public class TimeTest {
	@Inject
	TimeMapper time;
	
	@Inject
	TimeBean timeBean;
	
	@Test
	public void testNow(){
		System.out.println(time.now());
	}
	
	@Test
	@Transactional(rollbackOnly=true)
	public void testNow2(){
		System.out.println(timeBean.normalRun());
	}
}
