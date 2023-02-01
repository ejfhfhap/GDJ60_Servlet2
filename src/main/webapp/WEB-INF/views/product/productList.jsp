<%@page import="java.util.List"%>
<%@page import="com.iu.home.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>product List Page</h1>
	<% 
		//ProductDTO dto = (ProductDTO)request.getAttribute("one");
		
	%>
	<%
		List<ProductDTO> dtos = (List<ProductDTO>)request.getAttribute("list");
		for(ProductDTO dto : dtos){
	%>
	<h3><a href = "./detail.do?productNum=<%=dto.getPRODUCT_NUM()%>"><%= dto.getPRODUCT_NUM() %></a></h3>
	<h3><%= dto.getPRODUCT_NAME() %></h3>
	
	<%} %>
</body>
</html>