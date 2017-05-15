package com.madx.mybatis.suites;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.cdi.Transactional;

import com.madx.mybatis.WeldJUnit4Runner;
import com.madx.mybatis.data.mappers.TimeMapper;



@RunWith(WeldJUnit4Runner.class)
public class UserMapperTestReadWrite {

	@Inject
	TimeMapper timeMapper;

	@Test
	public void t1_select_one() {
		Integer number = timeMapper.count();
		assertEquals(Integer.valueOf(1), number);
	}

	
	@Test
	@Transactional(rollbackOnly = true)
	public void t1_insert_price() {
		int sizeBefore = timeMapper.count();
		
		timeMapper.addName("E");
		
		int sizeAfter = timeMapper.count();
		assertEquals(sizeBefore + 1, sizeAfter);
	}
}
