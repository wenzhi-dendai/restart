<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  
  <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="add" method="post" commandName="user">
		<table>
			<tr>
				<td>用户名</td>
				<td><form:input path="user_name"/><form:errors path="*" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><form:password path="user_mailsta"/></td>
			</tr>	
			<tr>
				<td>性别</td>
				<td><form:radiobuttons items="${sex}" path="user_sex"/></td>
			</tr>		
			<tr>
				<td>班级</td>
				<td><form:select path="clazz.class_id" items="${list}" itemLabel="class_name" itemValue="class_id"/></td>
			</tr>						
			<tr>
				<td></td>
				<td><input type="submit" value="注册" /></td>
			</tr>	
		</table>
	</form:form>
</body>
</html>