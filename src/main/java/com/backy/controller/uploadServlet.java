package com.backy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload.do")
public class uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String savePath = "upload"; //다운받을 경로
		int uploadFileSizeLimit = 5*1024*1024; //5M 업로드 제한
		String encType ="utf-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("서버가 실제 디렉토리 :");
		System.out.println(context.getRealPath(savePath));
		
		try {
			MultipartRequest multi 
				= new MultipartRequest(
						request, 
						uploadFilePath,//서버상 실제 파일 저장경로
						uploadFileSizeLimit,//파일제한 크기 5M
						encType,//인코딩 utf-8
						new DefaultFileRenamePolicy()//파일중복되면 파일명뒤 숫자첨부
						);
			//서버에 저장된 파일명(실제파일이름과 상이할 수 있음)
			String fileName = multi.getFilesystemName("uploadFile");
			
			if(fileName == null) {//upload 실패
				System.out.println("파일 업로드 실패!");
			}else {//upload 성공
				out.println("<br> 작성자 : " + multi.getParameter("name"));
				out.println("<br> 제목 : " + multi.getParameter("title"));
				out.println("<br> 파일명 : " + fileName);
				out.println("<br> 파일명 : " + multi.getOriginalFileName(uploadFilePath));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
