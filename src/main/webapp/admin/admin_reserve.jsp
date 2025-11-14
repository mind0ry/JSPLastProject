<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <main class="admin-main">
    <section class="recent-section">
      <h3>📅 예약 목록</h3>
      <table>
        <tr>
	        <th>번호</th>
	        <th></th>
	        <th>맛집명</th>
	        <th>ID</th>
	        <th>예약일</th>
	        <th>시간</th>
	        <th>인원</th>
			<th></th>
        </tr>
		<c:forEach var="vo" items="${rList }">
		  <tr>
	        <td>${vo.no }</td>
	        <td>
	          <img src="${vo.fvo.poster }" style="width:30px; height:30px;">
	        </td>
	        <td>${vo.fvo.name }</td>
	        <td>${vo.id }</td>
	        <td>${vo.rday }</td>
	        <td>${vo.time }</td>
	        <td>${vo.inwon }</td>
			<td>
			  <c:if test="${vo.ok==0 }">
			    <a href="../admin/reserve_ok.do?no=${vo.no }" class="btn btn-xs btn-success">승인대기</a>
			  </c:if>
			  <c:if test="${vo.ok==1 }">
			    <span class="btn btn-xs btn-default">승인완료</span>
			  </c:if>
			</td>
        </tr>
		</c:forEach>
      </table>
    </section>
    </main>
</body>
</html>