package com.madx.mybatis.sessions;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.cdi.SessionFactoryProvider;

import com.madx.mybatis.data.utils.factory.ConnectionFactory;

@RequestScoped
public class SqlSessionFactoryProviderImpl implements SqlSessionFactoryProvider {
	@Override
    @Produces
    @ApplicationScoped
    @SessionFactoryProvider
    public SqlSessionFactory produceFactory() {
        return ConnectionFactory.getSqlSessionFactory();
    }
}
