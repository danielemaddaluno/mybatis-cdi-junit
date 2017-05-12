package com.madx.mybatis;

import javax.inject.Inject;

import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Rule;
import org.junit.Test;

import com.madx.mybatis.data.mappers.TimeMapper;


public class TimeTest3 {
	@Rule
    public WeldInitiator weld = WeldInitiator.from(TimeMapper.class).inject(this).build();
	
	@Inject
	TimeMapper time;
	
	@Test
	public void testNow(){
		System.out.println(time.now());
	}
}
