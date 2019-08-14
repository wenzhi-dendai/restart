<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://shiro.apache.org/tags"  prefix="shiro"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>登录界面</h1>


	<form action="login" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="user_name" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="user_mailsta" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="登录" /> <input type="reset"
					value="重置" /></td>
			</tr>
		</table>
	</form>
	
	


	<shiro:guest>
    	欢迎游客访问，<a href="login">登录</a>
	</shiro:guest>
<br><br><br>
	<shiro:user>
	    欢迎[<shiro:principal />]登录，<a href="logout.jsp">注销</a>
	</shiro:user>
<br><br><br>
	<shiro:authenticated>
	    用户[<shiro:principal />]已身份验证通过。
	</shiro:authenticated>
<br><br><br>
<shiro:notAuthenticated>
    用户未身份验证。
</shiro:notAuthenticated>

<br><br><br>

	 <shiro:user>
		欢迎[<shiro:principal property="user_name"/>]登录，
		<a href="logout">注销</a>
	</shiro:user> 

<br><br><br>

	<shiro:hasRole name="admin">
	  用户[<shiro:principal property="user_name"/>]拥有角色admin
	</shiro:hasRole> 
	
<br><br><br>	
	
<shiro:hasAnyRoles name="admin,sta">
  用户[<shiro:principal property="user_name"/>]拥有admin,user角色
</shiro:hasAnyRoles>
	
<br><br><br>

<shiro:lacksRole name="sta">
  用户[<shiro:principal property="user_name"/>]没有admin角色。
</shiro:lacksRole>


</body>
</html>