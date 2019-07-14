package com.example.spring01.model.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.spring01.model.dto.MemberDTO;

@Repository
// 스프링에서 클래스를 알아서 만들고 소멸 자동으로 해줌
// 현재 클래스가 서버가 올라올때, 자동으로 메모리에 올려준다
// 나중에 inject만 붙이면 된대. 
public class MemberDAOImpl implements MemberDAO {

	private static final Logger logger=
			LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Inject
	//Inject 의존관계 주입
	SqlSession sqlSession;	
	
	@Override
	public List<MemberDTO> memberList() {
		logger.info("!!!!memberlist called...");
		//sql mapper에 작성된 sql 코드가 실행됨(auto commit & close)		
		// 아래 코드를 자동으로 다 해줌
		// List<MemberDTO> list= sqlSession.selectList("member.memberList");
		// sqlSession.commit();  sqlSession.close();
		// return list;
		//return list;
		return sqlSession.selectList("member.memberList");
	}

	@Override
	public void insertMember(MemberDTO vo) {
		//auto commit&close
		sqlSession.insert("member.insertMember", vo);

	}

	@Override
	public MemberDTO viewMember(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMember(String userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember(MemberDTO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		// TODO Auto-generated method stub
		return false;
	}

}
