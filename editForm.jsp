<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
  String num = request.getParameter("num");
  // 해당 num 값을 이용하여 데이터를 조회하고, 수정을 위한 폼을 구성할 수 있습니다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>글 내용</h3>
	 
 		
		<form action="editForm" method="post">
		<input type="hidden" name="num" value="<%= num %>">
		<input type="text" name="updateTitle" value="${detail.title}"  required> <br>
		<input type="text" name="updateWriter" value="${detail.writer}" required> <br>
		<textarea rows="4" cols="22" name="updateContent" placeholder="내용" >${detail.content}</textarea> <br>
		 
 	<button>수정</button>  
 	</form>
 		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	  <script src="${contextPath}/resources/js/boardForm.js"></script>
</body>
</html>