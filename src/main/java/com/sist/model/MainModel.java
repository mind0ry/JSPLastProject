package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
 * 	JSP(Java Server Pages)
 *  JSP
 *    1) 자바 기반의 서버사이드 웹 기술
 *    2) HTML내부에 자바코드를 첨부해서 동적페이지 생성
 *    3) Servlet을 쉽게 작성하기 위한 표현 언어
 *    4) JSP 파일은 _jspService()메소드 영역
 *  1. JSP 구성요소
 *    1) 선언문
 *       <%! %> : 멤버변수 , 메소드 선언
 *    2) 스크립트릿
 *       <% %> : 실행 코드 => _jspService(){여기에 첨부}
 *    3) 표현식
 *       <%= %> : 데이터를 화면에 출력
 *       => 변경 : out.println(<%=%>) => ;을 사용할 수 없다
 *    4) 주석 : <%-- --%> 사라진다 <!-- -->는 남아 있다
 *    				| 자바 포함 		| HTML만 주석
 *  
 *  2. JSP의 지시자
 *  	<%@ page %> : JSP파일에 대한 정보
 *  				  속성
 *  					= contentType
 *  					   => 브라우저 실행
 *                         => HTML : text/html; charset=UTF-8
 *                         => XML : text/xml;charset=UTF-8
 *                         => JSON : text/plain;charset=UTF-8
 *  	                = import : 필요한 라이브러리 읽기
 *  					  <%@ page import="java.util.*"%>
 *  					  <%@ page import="java.util.*,java.io.*"%>
 *  				    = errorPage : 에러발생시 이동하는 파일을 설정
 *  				      errorPage="error.jsp"
 *  					  => 기본 : forward를 사용하고 있다
 *   						*** URL주소 (request를 가지고 있다)
 *   			        = a.jsp ==> b.jsp
 *   							 | request가 초기화
 *                      = a.jsp
 *                         => b.jsp포함
 *      <%@ taglib %> : JSP에서 자바를 제거하기 위해 사용
 *      					   --------
 *      	                   | 자바 기능을 가지고 있어야 한다
 *                               -------
 *                               제어문 / 변환 / 함수
 *                                             | function
 *                                       | format
 *                                 | core
 *                 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
 *                 						  | 라이브러리 읽기
 *                              | 사용자 지정 => 시작태그
 *                              <c:set> : 변수 선언
 *                                | request.setAttrubute
 *                              <c:forEach> 
 *                              <c:if> 
 *                              <c:redirect> 
 *                              <c:choose>
 *                 <%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
 *                              <%= ((MemberVO)request.getAttribute("vo")).getName()%>
 *                              ${vo.name}
 *                              <fmt:formatDate pattern="yyyy-MM-dd">
 *                              <fmt:formatNumber pattern="#,###,###">
 *                              => toLocalString() : JavaScript
 *                 <%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
 *      <%@ include %> : 특정 JSP부분에 다른 JSP를 첨부
 *      					=> 정적페이지
 *      			        => 소스+소스 = 컴파일
 *                          => 동적
 *                              <jsp:include page="">
 *                              ---------------------
 *                              소스  소스
 *                               |    |
 *                              컴파일 컴파일
 *                               |    |
 *                               ------
 *                                 |
 *                                 HTML
 */
@Controller
public class MainModel {
  @RequestMapping("main/main.do")
  public String main_main(HttpServletRequest request, HttpServletResponse response) {
	  
	  request.setAttribute("main_jsp", "../main/home.jsp");
	  return "../main/main.jsp";
  }
}
