package com.madx.mybatis;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.madx.mybatis.data.mappers.TimeMapper;


@RunWith(Arquillian.class)
public class TimeTestArquillian {

//	// This static method builds the virtual test deployment archive
//    @Deployment
//    public static JavaArchive createDeployment() {
//        return ShrinkWrap.create(JavaArchive.class)
//            .addClass(TimeMapper.class)
//            .addAsResource("META-INF/beans.xml")
//            .addAsManifestResource(EmptyAsset.INSTANCE, "META-INF/beans.xml");
//    }
//
//	@Deployment
//    public static WebArchive createDeployment() {
//        return ShrinkWrap.create(WebArchive.class, "test.war")
//            .addPackage(TimeMapper.class.getPackage())
//            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
//    }
	
	// This static method builds the virtual test deployment archive
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
        	.addClass(TimeMapper.class)
            .addPackage(TimeMapper.class.getPackage())
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
	
	@Inject
	TimeMapper time;
	
	@Test
	public void testNow(){
		System.out.println(time.now());
	}
}
