package com.dev.dao;

import java.sql.*;

import com.dev.vo.MemberVO;
import com.edu.beans.Member;

public class MemberDAO {
	
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {};
	
	public static MemberDAO getInstance() {
		return dao;
	}

	public Connection connect() {

		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
				System.out.println("오류 발생  : " + ex);
			}
		}
	}
	
	public void close(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ex) {
				System.out.println("오류 발생  : " + ex);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				System.out.println("오류 발생  : " + ex);
			}
		}
	}
	
	
	
	public void insertMember(MemberVO member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = connect();
			pstmt = conn.prepareStatement("INSERT INTO member2 VALUES(?,?,?,?)");
			
			pstmt.setString(1,  member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getMail());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt);
		}
	}
}
