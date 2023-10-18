package com.backy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.backy.dto.ProductVO;

public class ProductDAO {
	private ProductDAO() {}
	
	private static ProductDAO instence = new ProductDAO(); 
	
	public static ProductDAO getInstance() {
		return instence;
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds;
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(conn != null) conn.close();
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, PreparedStatement ps) {
		try {
			if(conn != null) conn.close();
			if(ps != null) ps.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//DB 전체 DATA 검색
	public List<ProductVO> selectAllProduct(){
		
		List<ProductVO> productList = new ArrayList<ProductVO>();
		
		String sql = "select * from product order by code desc";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setCode(rs.getInt("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setPictureurl(rs.getString("pictureurl"));
				vo.setDescription(rs.getString("description"));
				
				productList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ProductDAO.close(conn, ps, rs);
		}
		
		return productList;
	}
	//기본키 code 해당하는 데이터만 검색
	public ProductVO selectProductByCode(String code) {
		return null;
	}
	//id,password 체크
	public int userCheck(String userid, String pwd) {
		return 0;
	}
	//id 존재여부 체크
	public int confirmId(String userid) {
		return 0;
	}
	//데이터 추가
	public int insertProduct(ProductVO vo) {
		return 0;
	}
	//데이터 수정
	public int updateProduct(ProductVO vo) {
		return 0;
	}
}

