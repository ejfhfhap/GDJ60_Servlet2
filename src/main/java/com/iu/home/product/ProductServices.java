package com.iu.home.product;

import java.util.List;

public class ProductServices {
	private ProductDAO productDAO;
	private ProductOptionDTO productOptionDTO;
	private ProductDTO productDTO;
	
	public ProductServices() {
		productDAO = new ProductDAO();
		productDTO = new ProductDTO();
		productOptionDTO = new ProductOptionDTO();
	}
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	// 상품 하나 추가하기 서비스 클래스
	public int AddProduct(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
		int productNum = productDAO.getProductNum(); // 시퀀스 번호 구하기
		int result = productDAO.AddProduct(productNum, productDTO);
		
		for(ProductOptionDTO productOptionDTO : ar) {
			productOptionDTO.setProduct_num(productNum);
			result = productDAO.AddProductOption(productOptionDTO);
		}
		return result;
	}
	
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPRODUCT_NAME("product1");
		productDTO.setPRODUCT_DETAIL("detail1");
		
		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
		productOptionDTO.setOption_name("optionName1");
		productOptionDTO.setOption_price(100);
		productOptionDTO.setOption_each(10);
		productOptionDTO.setProduct_num(null);
		
		ProductOptionDTO productOptionDTO2 = new ProductOptionDTO();
		productOptionDTO2.setOption_name("optionName2");
		productOptionDTO2.setOption_price(200);
		productOptionDTO2.setOption_each(20);
		productOptionDTO2.setProduct_num(null);
		
		try {
			int num = productDAO.getProductNum();
			int result = productDAO.AddProduct(num, productDTO);
			
			productOptionDTO.setProduct_num(num);
			productOptionDTO2.setProduct_num(num);
			productDAO.AddProductOption(productOptionDTO);
			productDAO.AddProductOption(productOptionDTO2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
