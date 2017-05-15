package com.madx.mybatis.data.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.mybatis.cdi.Mapper;

@Mapper
public interface TimeMapper {
    @Select("SELECT NOW()")
    public String now();
    
    @Insert("INSERT INTO test(name) VALUES (#{name})")
    public void addName(String name);
    
    @Select("SELECT count(*) from test")
    public Integer count();
}
