package com.dev.service;

import com.edu.beans.Member;
import com.edu.dao.MemberDAO;

public class MemberService {
	
	private static MemberService service = new MemberService();
	public MemberDAO dao = MemberDAO.getInstance(); 
	
	private MemberService() {};
	public static MemberService getInstance() {
		return service;
	}
	
	public void memberInsert(MemberVO member) {
		dao.memberInsert(member);
	}
}
