<%@page import="com.model.ProductModel"%>
<%@page import="com.dao.Dao"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view products</title>
<!-- bootstrap css -->
      <link rel="stylesheet" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" href="css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>

	

<table class="table table-striped table-hover">
				<thead>
				<!-- <tr> -->
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
						<th>Name</th>
						<th>Category</th>
						<th>Model</th>
						<th>price</th>
						<th>description</th>
						<th>Image</th>
						<th>Action</th>
						
				<!-- </tr> -->	
				</thead>
				<tbody>
					
						<%
							List<ProductModel>list = Dao.viewdata();
										
							for(ProductModel m :list)
							{
								
							
						%>
						
						<tr>
								<td><%=m.getId() %></td>
								<td><%=m.getName() %></td>
								<td><%=m.getCategory() %></td>
								<td><%=m.getModel() %></td>
								<td><%=m.getPrice() %></td>
								<td><%=m.getDes() %></td>
								<td><img src="data:images/jpeg;base64,<%=m.getImage()%>" width="150px" height="200px" /></td>
								
								
								<td>
								<a href="edit.jsp?id=<%=m.getId()%>">
								<img src="images/edit.png" width="20px" height="20px"/>
								</a>
								</td>
								
								<td>
								<a href="delete.jsp?id=<%=m.getId()%>">
								<img src="images/delete.png" width="20px" height="20px"/>
								</a>
								</td>
								
						</tr>
						
						
						
						<%
							}
						%>
					
				</tbody>
			</table>	

</body>
</html>