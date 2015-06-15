<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시물 상세정보</h1>
 <form action = 'change.do' method = 'post'>
<table border='1'>
<tr>
<th>번호</th><td><input name = 'no' type = 'text' readonly value = '${board.no}'> </td>
</tr>
<tr>
<th>제목</th><td><input name = 'title' type = 'text' value = '${board.title}'></td>
</tr>
<tr>
<th>내용</th><td><textarea name = 'content' rows='5' cols ='50'>${board.content}</textarea></td>
</tr>
<tr>
<th>등록일</th><td><input type = 'text' readonly value = '${board.createDate}'></td>
</tr>
<tr>
<th>조회수</th><td><input type = 'text' readonly value = '${board.views}'></td>
</tr>
</table>
<button type = 'submit'> 변경 </button>
<button type = 'button' onclick = 'location.href="remove.do?no=15";' > 삭제 </button>
</form>
</body>
</html>
