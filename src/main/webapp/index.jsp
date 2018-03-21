<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: тимур50
  Date: 27.02.2018
  Time: 3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ua.com.timur.common.AppConsts" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello World Action!</h1>
<form action="login.action">
    <input type="text" name="name">
    <input type="submit" name="Submit">


</form>

<a href="https://testua.oauth.avest.org/oauth/authorize?response_type=code&client_id=8HyfiUokftWnCO4mV15vcg0d30Jt0939&authentication=phone&scope=sign&redirect_uri=http://localhost:8080/webapp-1.0-SNAPSHOT/mobileid"> Mobile ID  </a>

<% if(1==2) {%>
    <p>test java code</p>
<%}%>
<% if(request.getParameter("code")!= null){%>
    <p>get code</p>
<%}%>
</body>
</html>
