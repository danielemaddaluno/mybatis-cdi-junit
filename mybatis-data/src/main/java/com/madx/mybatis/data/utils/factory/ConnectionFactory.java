package com.madx.mybatis.data.utils.factory;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class ConnectionFactory {
	static FactoryType factoryType;
	private static SqlSessionFactory factory;
	private static final String PROJECT_PACKAGE = "com.madx.mybatis.data";
	private static final String MAPPERS_PACKAGE = PROJECT_PACKAGE + ".mappers";

	private static SqlSessionFactory getSqlSessionFactoryJava(){
		if(ConnectionFactory.factoryType == null) ConnectionFactory.factoryType = FactoryType.DEVELOPMENT;
		DataSource dataSource = factoryType.getDataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment(factoryType.enviromentName(), transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);

		// this line added because in java fields are camelized but in the db fields the underscores are used
		configuration.setMapUnderscoreToCamelCase(true);
		// this line adds all the mapper that for convention are located in the package MAPPERS_PACKAGE 
		configuration.addMappers(MAPPERS_PACKAGE);
		return new SqlSessionFactoryBuilder().build(configuration);
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		if(factory==null) factory = getSqlSessionFactoryJava();
		return factory;
	}
}
