package com.example.spring01;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" } )


public class MybatisTest {
	private static final Logger logger=
			LoggerFactory.getLogger(MybatisTest.class);
	
	@Inject //Autowired (root-context에있는것)
	private SqlSessionFactory sqlFactory;
	//sqlse..이걸 우리가 만든것이 아니고, 스프링에서 쓸수있게 해준것임
	
	//junit이 테스트하는코드
	@Test
	public void testFactory() {
	 logger.info("sqlFactory:" + sqlFactory);
	}
	
	@Test
	public void testSession() {
		//mybatis 실행을 위한 SqlSession 객체 생성
		try(SqlSession sqlSession= sqlFactory.openSession()){
			logger.info("sqlFactory:" + sqlFactory);
			logger.info("mybatis연결성공");			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
