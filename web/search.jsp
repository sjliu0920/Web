<%--
  Created by IntelliJ IDEA.
  User: double
  Date: 8/29/16
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<%@page import="java.util.Collection, java.util.Iterator" %>
<jsp:useBean id="cart" scope="session"
             class="web1.src.CartBean" ></jsp:useBean>
<html>
<head>
    <title>欢迎光临Costco</title>
</head>
<body>
<%--
    <jsp:include page="additem.jsp" flush="false" />
    --%>

    <%
        String strKeyword = request.getParameter("keyword");
        if(null == strKeyword || strKeyword.equals(""))
        {
            response.sendRedirect("catalog.jsp");
            return;
        }

        Collection cl = bookdb.searchBook(strKeyword);
        if(cl.size() <= 0)
        {
            System.out.println("对不起，没有找到条件的商品。");
            return;
        }
    %>
</body>
</html>
