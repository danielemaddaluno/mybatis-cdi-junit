package com.madx.mybatis;

import javax.inject.Inject;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.madx.mybatis.data.mappers.TimeMapper;

@RunWith(CdiRunner.class) 
public class TimeTest2 {
	@Inject
	TimeMapper time;
	
	@Test
	public void testNow(){
		System.out.println(time.now());
	}
}
