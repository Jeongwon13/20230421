<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%
  String num = request.getParameter("num");
  //*****해당 num 값을 이용하여 데이터를 조회하고, 수정을 위한 폼을 구성할 수 있습니다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용</title>
</head>
<body>
    
       
        <h3>글 내용</h3> 
      
       	 
    
      	<p>번호: ${detail.num}</p>
      	<p>제목: ${detail.title}</p>
        <p>작성자: ${detail.writer}</p>
        <p>내용: ${detail.content}</p>
        <p>작성일: ${detail.regdate}</p> 
         
        
      
 
   <c:url var="editUrl" value="editForm">
    <c:param name="num" value="${detail.num}" />
</c:url>
<a href="${editUrl}"><button>수정</button></a>

    <form action="boardDelete" method="POST" onsubmit="return uboardDelete()">
    	<input type="hidden" name="num" value="<%= num %>">
    
    <button id="deleteBtn">삭제</button></a>
    </form>
    
    
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/boardForm.js"></script>
</body>
</html>