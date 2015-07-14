<%@ page language="java" contentType="text/html; charset=UTF-8"  
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>新增用户</title>
<script type="text/javascript"
	src="<%=basePath%>/plug-in/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">  
function addUser(){  
    var form = document.forms[0];  
    form.action = "save.do";  
    form.method="post";  
    form.submit();  
}  
</script>  
</head>  
<body>  
<h1>添加用户</h1>
<form action="" name="userForm">
<input type="hidden" name="id" value="${userPage.id }">  
    姓名：<input type="text" name="userName" value="${userPage.userName }">
    年龄：<input type="text" name="age" value="${userPage.age }">  
    <input type="button" value="确定" onclick="addUser()">  
</form>  
</body>  
</html>