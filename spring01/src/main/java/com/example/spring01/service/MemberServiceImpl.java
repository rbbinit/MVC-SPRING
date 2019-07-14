package com.example.spring01.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.example.spring01.model.dao.MemberDAO;
import com.example.spring01.model.dto.MemberDTO;

@Service  //자동으로 메모리에 올려준다
public class MemberServiceImpl implements MemberService {

	@Inject //스프링 컨테이너가 만든 dao 객체가 연결됨(의존관계 주입)
	//MemberDao memberDao= new MemberDAOImpl(); 이렇게 짜지말고
	MemberDAO memberDao;
	
	@Override
	public List<MemberDTO> memberList() {
		// TODO Auto-generated method stub		
		return memberDao.memberList();
	}

	@Override
	public void insertMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		memberDao.insertMember(dto);
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
	public void updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		// TODO Auto-generated method stub
		return false;
	}

}
