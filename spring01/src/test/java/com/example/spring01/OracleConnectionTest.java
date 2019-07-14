package com.example.spring01;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleConnectionTest {
	private static final Logger logger=
			LoggerFactory.getLogger(OracleConnectionTest.class);
	private static final String DRIVER=
			"oracle.jdbc.driver.OracleDriver";
	private static final String URL=
			"jdbc:oracle:thin:@localhost:1521/orcl";
	private static final String USER="spring";
	private static final String PW="1234";
	
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try (Connection conn=
				DriverManager.getConnection(URL, USER, PW)) 
		// try ( ) 안에 있음연 자동 close (finally안써도)
		// 주의 java 1.7이상 (1.6 error 뜸)
		{
			System.out.println("오라클 연결");
			logger.info("오라클 연결");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
