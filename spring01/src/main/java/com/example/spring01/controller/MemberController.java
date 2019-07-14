package com.example.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring01.model.dto.MemberDTO;
import com.example.spring01.service.MemberService;

@Controller
public class MemberController {

	 //현재 클래스를 controller bean으로 등록시킴
	private static final Logger logger=
			LoggerFactory.getLogger(MemberController.class);
	
	@Inject  //MemberSerivce 객체가 주입됨
	MemberService memberService;
	//원래는 new MemberSerivceImpl() 이런식임
	
	@RequestMapping("member/list.do") //사용자가 요청하는 주소
	public String memberList(Model model) {
		List<MemberDTO> list= memberService.memberList();
		logger.info("회원목록(controller의 list) :" + list);		
		model.addAttribute("list", list); //모델에 저장
		
		return "member/member_list"; //출력페이지로 포워딩
				
	}
	@RequestMapping("member/write.do")
	public String write()
	{
		//보안때문에 이렇게 controller 거쳐서 감(로그남길때도 좋고)
		return "member/write";
	}
	
	@RequestMapping("member/insert.do")
	public String insert(@ModelAttribute MemberDTO dto)
	{
		//parameter에 HttpServletRequest request 넣고
		// String name=request.getParameter("name"); 로 해도됨
		//MemberDTO 자료형안에 있는 변수와 반드시 일치해야함.
		memberService.insertMember(dto);
		return "redirect:/member/list.do"; //목록 갱신
	}
}
