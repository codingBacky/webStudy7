<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
  <h2>상품 등록 - 관리자 페이지</h2>
  <form action="/productWrite.do" method="post" enctype="multipart/form-date" name="frm">
    <div class="form-group">
      <label for="name">상품명:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
    </div>
    <div class="form-group">
      <label for="price">가격:</label>
      <input type="text" class="form-control" id="price" placeholder="Enter price" name="price">
    </div>
    <div>
      <label for="pictureurl">사진:</label>
      <input type="file" id="pictureurl" placeholder="Enter pictureurl" name="pictureurl">
    </div>
    <div class="form-group">
      <label for="description">설명:</label>
      <textarea rows="10" cols="80" name="description"></textarea>
      (주의사항: 이미지를 변경하고자 할때만 선택하세요)
    </div>

    <button type="submit" class="btn btn-primary">Registration</button>
    <button type="reset" class="btn btn-info">Rewrite</button>
    <button type="button" class="btn btn-primary" onclick="location.href='productList.do'">List</button>
  </form>
</div>

</body>
</html>