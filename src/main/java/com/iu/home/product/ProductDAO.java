package com.iu.home.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sam.home.util.DBConnection;

public class ProductDAO {
	public int getProductNum() throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		int num = resultSet.getInt(1);
		DBConnection.disConnection(resultSet, preparedStatement, connection);
		return num;
	}
	public List<ProductOptionDTO> getProductOptionList() throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCT_OPTION";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		ArrayList<ProductOptionDTO> ar = new ArrayList<>();
		while(resultSet.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
			productOptionDTO.setOption_num(resultSet.getInt("OPTION_NUM"));
			productOptionDTO.setProduct_num(resultSet.getInt("PRODUCT_NUM"));
			productOptionDTO.setOption_name(resultSet.getString("OPTION_NAME"));
			productOptionDTO.setOption_price(resultSet.getInt("OPTION_PRICE"));
			productOptionDTO.setOption_each(resultSet.getInt("OPTION_EACH"));
			ar.add(productOptionDTO);
		}
		DBConnection.disConnection(resultSet, preparedStatement, connection);
		return ar;
	}
	public int AddProductOption(ProductOptionDTO productOptionDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCT_OPTION VALUES(PRODUCT_OPTION_SEQ.NEXTVAL,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, productOptionDTO.getProduct_num());
		preparedStatement.setString(2, productOptionDTO.getOption_name());
		preparedStatement.setInt(3, productOptionDTO.getOption_price());
		preparedStatement.setInt(4, productOptionDTO.getOption_each());
		
		int result = preparedStatement.executeUpdate();
		DBConnection.disConnection(preparedStatement, connection);
		return result;
		
//		private Integer option_num;
//		private Integer product_num;
//		private String option_name;
//		private Integer option_price;
//		private Integer option_each;
	}
	public List<ProductDTO> getProductList() throws Exception{
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT PRODUCT_NUM,PRODUCT_NAME,PRODUCT_RATE"
				+ " FROM PRODUCT ORDER BY PRODUCT_RATE DESC";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setPRODUCT_NUM(resultSet.getInt("PRODUCT_NUM"));
			productDTO.setPRODUCT_NAME(resultSet.getString("PRODUCT_NAME"));
			productDTO.setPRODUCT_RATE(resultSet.getDouble("PRODUCT_RATE"));
			ar.add(productDTO);
		}
		DBConnection.disConnection(resultSet, preparedStatement, connection);
		return ar;
	}
	public int AddProduct(int num, ProductDTO productDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCT VALUES(?,?,?,0.0)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, num);
		preparedStatement.setString(2, productDTO.getPRODUCT_NAME());
		preparedStatement.setString(3, productDTO.getPRODUCT_DETAIL());
	//	preparedStatement.setDouble(3, productDTO.getPRODUCT_RATE());

		
		int result = preparedStatement.executeUpdate();
		DBConnection.disConnection(preparedStatement, connection);
		
		return result;
		
//		private Integer item_num;
//		private String account_name;
//		private double rate;
//		private String detail;
//		private String status;
	}
	
}
