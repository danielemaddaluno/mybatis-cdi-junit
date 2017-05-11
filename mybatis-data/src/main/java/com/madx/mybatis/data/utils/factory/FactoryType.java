package com.madx.mybatis.data.utils.factory;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.jndi.JndiDataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSource;

public enum FactoryType {
	DEVELOPMENT("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/mybatis", "root", "root", false),
	TEST("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/mybatis", "root", "root", false),
	DEVELOPMENT_JNDI("java:/Mybatis", true),
	TEST_JNDI("java:/Mybatis", true);
	
	private String driver;
	private String url;
	private String username;
	private String password;
	
	private String jndiName;
	
	private boolean jndi;

	FactoryType(String driver, String url, String username, String password, boolean jndi){
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
		this.jndi = jndi;
	}
	
	FactoryType(String jndiName, boolean jndi){
		this.jndiName = jndiName;
		this.jndi = jndi;
	}
	
	public String enviromentName(){
		return this.name().toLowerCase();
	}

	public DataSource getDataSource() {
		if(this.jndi){
			JndiDataSourceFactory jndiFactory = new JndiDataSourceFactory();
			Properties props = new Properties();
			props.setProperty(JndiDataSourceFactory.DATA_SOURCE, this.jndiName);
//			props.setProperty("autoCommitOnClose", "false");
			
			jndiFactory.setProperties(props);
			return jndiFactory.getDataSource();
		} else {
			return new PooledDataSource(this.driver, this.url, this.username, this.password);
		}
	}
}
