<%--
  Created by IntelliJ IDEA.
  User: double
  Date: 8/29/16
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎光临costco</title>

</head>
<body>
<h1> 欢迎光临costco </h1>
搜索图书<br>
<form method="get" action="search.jsp">
    请输入关键字：<input type="text" name="keyword"/>
    <input type="submit" value="搜索"/>
</form>
<br><a href="catalog.jsp">查看所有商品</a>
</body>
</html>
