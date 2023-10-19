<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <h2>상품 등록 - 관리자 페이지</h2>
  <form action="productUpdate.do" method="post" enctype="multipart/form-data" name="frm">

 	<input type="hidden" name="code" value=${product.code }>
 	<input type="hidden" name="nonmakeImg" value=${product.pictureurl }>
 	
 	<c:choose>
 		<c:when test="${empty product.pictureurl }">
 			<img src="upload/noimage.gif" width="300" height="450">
 		</c:when>
 		<c:otherwise>
 			<img src="upload/${product.pictureurl }" width="200" height="300">
 		</c:otherwise>
 	</c:choose>
 	
    <div class="form-group">
      <label for="name">상품명:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="${product.name }">
    </div>

    <div class="form-group">
      <label for="price">가격:</label>
      <input type="text" class="form-control" id="price" placeholder="Enter price" name="price" value="${product.price }">
    </div>

    <div>
      <label for="pictureurl">사진 :</label>
      <input type="file" id="pictureurl" name="pictureurl"/> <br /> 
      (주의사항: 이미지를 변경하고자 할때만 선택하세요)
    </div>

    <div class="form-group">
      <label for="description">설명:</label>
      <textarea rows="10" cols="80" name="description">${product.description }</textarea>
     
    </div>

    <button type="submit" class="btn btn-primary">Modify</button>
    <button type="reset" class="btn btn-info">Rewrite</button>
    <button type="button" class="btn btn-primary" onclick="location.href='productList.do'">List</button>
  </form>
</div>
</body>
</html>