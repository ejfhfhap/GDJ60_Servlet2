package com.iu.home.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    private ProductServices productServices;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        productDAO = new ProductDAO();
        productServices = new ProductServices();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("product page");
		
		int index = request.getRequestURI().lastIndexOf("/");
		String choose = request.getRequestURI().substring(index + 1);
		System.out.println(choose);
		
		RequestDispatcher requestDispatcher = null;
		// list,add,update,delete,detail .do
		String address = "";
		
		if(choose.equals("list.do")) {
			try {
				List<ProductDTO> ar = productServices.getProductList();
				request.setAttribute("list", ar); // jsp로 변수 보내기	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			address = "productList.jsp";
		}else if(choose.equals("add.do")) {
			address = "productAdd.jsp";
		}else if(choose.equals("update.do")) {
			address = "productUpdate.jsp";
		}else if(choose.equals("delete.do")) {
			address = "productDelete.jsp";
		}else if(choose.equals("detail.do")) {
			int num = Integer.parseInt(request.getParameter("productNum"));
			ProductDTO temp = new ProductDTO();
			temp.setPRODUCT_NUM(num);
			try {
				ProductDTO productDTO = productServices.getProductDetail(temp);
				request.setAttribute("productDTO", productDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			address = "productDetail.jsp";
		}
		
		requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/product/" + address);
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
