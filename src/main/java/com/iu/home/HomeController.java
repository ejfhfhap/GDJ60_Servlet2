package com.iu.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello juhyeong");
		
		// 클라이언트 한테 보내는 메세지 임시 jsp 만드는 과정
//		PrintWriter out = response.getWriter();
//		out.println("<H1> JU HYEONG </H1>");
//		out.close();
//		String method = request.getMethod();
//		System.out.println(method);
//		StringBuffer url = request.getRequestURL();
//		System.out.println("URL : " + url);
//		String uri = request.getRequestURI(); // uri에서 루트부터 경로만 포함함
//		System.out.println("URI : " + uri); // uri에서 루트부터 경로만 포함함
//		
//		Cookie[] cookies = request.getCookies();
//		for(Cookie cookie : cookies) {
//			System.out.println(cookie.getName() + " " + cookie.getValue());
//		}
//		
//		String context = request.getContextPath();
//		System.out.println("context path : " + context);
//		// 위에꺼 대신에서 jsp파일을 보냄
//		String age = request.getParameter("age");
//		System.out.println("age is " + Integer.parseInt(age));
//		
//		String[] moneys = request.getParameterValues("money");
//		for(String m : moneys) {
//			System.out.println(m);
//		}
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/views/home.jsp"); // 루트가 GDJ60_Servlet2가 아님
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
