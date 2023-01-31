package com.sam.home.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sam.home.util.DBConnection;

public class MemberDAO {
	public int AddMember(MemberDTO memberDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO MEMBER2 VALUES(MEMBER_ID_SEQ.NEXTVAL,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, memberDTO.getPw());
		preparedStatement.setString(2, memberDTO.getName());
		preparedStatement.setString(3, memberDTO.getAddress());
		preparedStatement.setString(4, memberDTO.getCall());
		preparedStatement.setString(5, memberDTO.getEmail());
		
		int result = preparedStatement.executeUpdate();
		DBConnection.disConnection(preparedStatement, connection);
		
		return result;
		
//		private String id;
//		private String pw;
//		private String name;
//		private String address;
//		private String call;
//		private String email;
	}
}
