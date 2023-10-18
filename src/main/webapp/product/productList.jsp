<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <h2>상품리스트 - 관리자 페이지</h2>
  <a href="productWrite.do" class="btn float-right">상품 등록</a>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>이름</th>
        <th>가격</th>
        <th>수정</th>
        <th>삭제</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach var="product" items="${productList }">
      <tr>
        <td>${product.code}</td>
        <td>${product.name}</td>
        <td><fmt:formatNumber value="${product.price }"></fmt:formatNumber>원</td>
        <td>상품 수정</td>
        <td>상품 삭제</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>