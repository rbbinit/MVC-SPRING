package com.example.spring01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.spring01.model.dto.ProductDTO;

@RestController  //스프링 4.0부터 사용 가능
//그 이하면 그냥 Controller로 하면 됨
//Controller 없으면 메모리에 안 올라옴. (있어야 맵핑됨.)
public class SampleRestController {
	private static final Logger logger=
			LoggerFactory.getLogger(MainController.class);
	
	
	/*
	 * //@ResponseBody //Controller일때 이거 써야됨. json형식으로 리턴
	 * //@RequestMapping("test/doF") public ProductDTO doF() {
	 * 
	 * logger.info("doF"); return new ProductDTO("냉장고", 500000); //이건 view가 아니라
	 * data로 넘기는것임. } //json은 {"냉장고": "abc", "price":5000 };
	 */}
