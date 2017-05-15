package com.madx.mybatis.suites;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mybatis.cdi.Transactional;

import com.madx.mybatis.WeldJUnit4Runner;
import com.madx.mybatis.data.mappers.TimeMapper;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(WeldJUnit4Runner.class)
public class UserMapperTestReadWrite {

	@Inject
	TimeMapper timeMapper;

	String name = "E";

	@Test
	@Transactional(rollbackOnly = true)
	public void t1_insert() {
		Integer sizeBefore = timeMapper.count();
		assertEquals(Integer.valueOf(0), sizeBefore);
		

		timeMapper.addName(name);

		Integer sizeAfter = timeMapper.count();
		assertEquals(Integer.valueOf(sizeBefore + 1), sizeAfter);
	}
	
	@Test
	public void t2_count() {
		Integer number = timeMapper.count();
		assertEquals(Integer.valueOf(0), number);
	}

	@Test
	public void t3_remove() {
		timeMapper.remove(name);
	}
}
