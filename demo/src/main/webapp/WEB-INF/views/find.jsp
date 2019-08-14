<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deleteTest(id){
		if (confirm("确认删除")) {
			document.getElementById("deleteFrom").action="delete/"+id;
			document.getElementById("deleteFrom").submit();
		}
	}

</script>

</head>
<body>
	<a href="add">添加</a>
	<table border="1" width="600">
		<tr>
			<td>名字</td>
			<td>邮件</td>
			<td>性别</td>
			<td>部门</td>
			<td>操作</td>
		</tr>
	
	<c:forEach items="${list}" var="s">
		<tr>
			<td>${s.user_name}</td>
			<td>${s.user_mailsta}</td>
			<td>${s.user_sex}</td>
			<td>${s.clazz.class_name}</td>
			<td><a href="update/${s.user_id}">编辑</a> <a href="javascript:deleteTest(${s.user_id})">删除</a></td>
		</tr>
	
	</c:forEach>
	
	</table>
	<form:form id="deleteFrom" method="delete"/>
</body>
</html>