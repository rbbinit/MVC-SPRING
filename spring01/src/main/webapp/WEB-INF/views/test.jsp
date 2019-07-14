<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="include/header.jsp" %>
<script>
function doF() {
	$.ajax({  //비동기적 방식(현재 페이지에 그대로. 백그라운드. 서버에서 호출됨)
		type:"post",
		url: "${path}/test/doF",  // url에서 test/doF호출하고
		success: function(result) { //result가 return 값 받음
			$("#result").html("상품명 : "+ result.name + ",가격:"+ result.price);
			
		} //result가 string인데, type이 다르기 때문에
		//dto를 변환시켜서 바꿔서 보내야한다. 즉 dto를 string으로
		//변환기가 jackson-databind를 dependency에 추가한것임
	});
}
</script>
</head>

<!-- WEB-INF안에 있기 때문에 controller를 통하지 않고 못간다 -->
<body>
<%@ include file="include/menu.jsp" %>
<h2>링크 테스트</h2>
<a href="${path}/test/doA">doA</a><br>
<a href="${path}/test/doB">doB</a><br>
<a href="${path}/test/doC">doC</a><br>
<a href="${path}/test/doD">doD</a><br>
<!-- <a href="javascript:doF()">doF</a><br>
-->
<div id="result"></div>
</body>
</html>