package com.backy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backy.dao.ProductDAO;
import com.backy.dto.ProductVO;


@WebServlet("/productDelete.do")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO pDao = ProductDAO.getInstance();
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		
		System.out.println(name);
		
		//pDao.deleteProduct(code);
		
		ProductVO vo = pDao.selectProductByCode(code);
		
		//request.setAttribute("product", code);
		//request.setAttribute("product", name);
		request.setAttribute("product", vo);
		
		RequestDispatcher dis = request.getRequestDispatcher("product/productDelete.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		ProductDAO pDao = ProductDAO.getInstance();
		int result = pDao.deleteProduct(code);
	}

}
