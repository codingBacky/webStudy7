<%@page import="com.backy.dao.ProductDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

ProductDAO mDao = ProductDAO.getInstance();
Connection conn = mDao.getConnection();
out.println("conn test: " + conn);

%>
</body>
</html>