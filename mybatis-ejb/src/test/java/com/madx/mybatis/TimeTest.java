package com.madx.mybatis;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.madx.mybatis.data.mappers.TimeMapper;

@RunWith(WeldJUnit4Runner.class) 
public class TimeTest {
	@Inject
	TimeMapper time;
	
	@Test
	public void testNow(){
		System.out.println(time.now());
	}
}
