package com.backy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backy.dao.ProductDAO;
import com.backy.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/productUpdate.do")
public class ProductUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		System.out.println(code);
		
		ProductDAO pDao = ProductDAO.getInstance();
		ProductVO vo = pDao.selectProductByCode(code);
		
		request.setAttribute("product", vo);
		
		RequestDispatcher dis = request.getRequestDispatcher("product/productUpdate.jsp");
		dis.forward(request, response);//product/productUpdate.jsp의 post에 request 전달됨
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		
		System.out.println(request.getParameter("pictureurl"));
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		int sizeLimit = 5*1024*1024;
		String encType = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(request,
													  path,
													  sizeLimit,
													  encType,
													  new DefaultFileRenamePolicy());
		
		String code = multi.getParameter("code");
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		String pictureurl = multi.getFilesystemName("pictureurl");
		if(pictureurl == null) {
			pictureurl = multi.getParameter("nonmakeImg");
		}
		
	
		
		
		ProductVO vo = new ProductVO();
		vo.setCode(Integer.parseInt(code));
		vo.setName(name);
		vo.setPrice(price);
		vo.setPictureurl(pictureurl);
		vo.setDescription(description);
		
		System.out.println(vo);
		
		
		ProductDAO pDao = ProductDAO.getInstance();
		int result = pDao.updateProduct(vo);
		System.out.println(result);
		if(result == 1) response.sendRedirect("productList.do");
		else response.sendRedirect("productWrite.do");
		
	}


}
