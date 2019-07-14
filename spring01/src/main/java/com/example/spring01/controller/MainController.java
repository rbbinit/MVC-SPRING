package com.example.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.dto.ProductDTO;


@Controller
//현재 클래스가 controller (전체 흐름 제어하는)
public class MainController {
	private static final Logger logger=
			LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/")
	public String main(Model model) {
		//model : 데이터를 담는 그릇 역할, map 구조로 저장됨
		//  ("변수명", 값)으로 
		model.addAttribute("message", "홈피 방문 환영");
		return "main"; //main.jsp로 forwarding됨
		//requestDispatcher 코드임
	
		//서버가 올라오면. 이미 알고있다 (이미 읽어서)
		//아까 mapping 된 gugu.do를 호출함 (왜? menu.jsp에서)
		//<a href="${path}/gugu.do">구구단</a> 했어서
	}
	
	@RequestMapping(value="gugu.do", method=RequestMethod.GET)	
	public String gugu(@RequestParam int dan, Model model) {		
		//int dan=9;		
		//방법 1 
		//파라미터에 HttpServletRequest request 
		//int dan= Integer.parseInt(request.getParameter("dan"));
		
		//방법2 파라미터에 int dan넣고,(@RequestParam int dan)
		//<a href="${path}/gugu.do?dan=5">구구단</a>
		String result="";
		for(int i=1; i<=9; i++) {
			result += dan + "x" + i + "=" + dan*i + "<br>";			
		}
		model.addAttribute("result", result);
	
		return "test/gugu";		
	}
	
	//리턴 타입이 VOID인 경우는?  이렇게도 가능
	@RequestMapping("test")
	public void test()
	{
		
	}	
	@RequestMapping("test/doA") //url pattern
	public String doA(Model model) {
		logger.info("doA called...");
		model.addAttribute("message", "홈피 방문 환영");
		return "test/doB";
	}
	
	@RequestMapping("test/doB")
	public void doB() {
		logger.info("doB called");
	}
	
	//ModelAndView : Model- 데이터 저장소, view 화면
	//데이터와 포워드할 페이지의 정보
	//forward: 주소 그대로, 화면 전환, 대량의 데이터 전달
	//redirect : 주소 바뀜, 화면 전환, 소량의 get 방식 데이터
	@RequestMapping("test/doC")
	public ModelAndView doC() {
		logger.info("doC called");
		Map<String, Object> map= new HashMap<String, Object> ();
		map.put("product", new ProductDTO("샤프", 1000));
		//map에 저장
		//modelandview는 출력할 페이지와 전달할 그릇도 있음
		//근데 값을 1개밖에 못 보냄. 
		//map변수에 product가 있는 것임
		return new ModelAndView("test/doC", "map", map);
	}
	
	//redirect
	//페이지 주소도 바뀌어버림
	@RequestMapping("test/doD")
	public String doD() {
		//redirect의 경우 return type을 String으로 설정
		//doE.jsp로 리디렉트됨
		return "redirect:/test/doE"; //포워드
		//return "redirect:/hello.jsp";
	}
	
	@RequestMapping("test/doE")
	public void doE() {
		//doE.jsp로 포워드
	}
}
