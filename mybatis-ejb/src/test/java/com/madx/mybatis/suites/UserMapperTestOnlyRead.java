package com.madx.mybatis.suites;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.cdi.Transactional;

import com.madx.mybatis.WeldJUnit4Runner;
import com.madx.mybatis.data.mappers.TimeMapper;

@Transactional(rollbackOnly = true)
@RunWith(WeldJUnit4Runner.class)
public class UserMapperTestOnlyRead {

	@Inject
	TimeMapper timeMapper;

	@Test
	public void t1_select() {
		Integer number = timeMapper.count();
		assertEquals(Integer.valueOf(1), number);
	}
}
