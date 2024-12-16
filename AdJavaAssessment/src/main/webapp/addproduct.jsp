<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>Insert title here</title>
</head>
<body style="background-color:peachpuff ;">

<div class="card bg-light">
		<article style="background:peachpuff;" class="card-body mx-auto" style="max-width: 400px;">
	<form action="insert.jsp"  method="post" >
			
					<h3 align="center">Add Product</h3>
					
			<div class="form-group input-group">
				<div class="input-group-prepend">
					
				</div>
				<input name="name" class="form-control" placeholder="product name"
					type="text" id="name">
				</div>
				
				
			<div class="form-group input-group">
				<div class="input-group-prepend">
					
				</div>
				 <input name="category" class="form-control"
					placeholder="product category" type="text" id="category">
				</div>
			
			
			<div class="form-group input-group">
				<div class="input-group-prepend">
					
				</div>
				<input name="model" class="form-control" placeholder="product model"
					type="text" id="model">
				</div>
				
				
				<div class="form-group input-group">
				<div class="input-group-prepend">
					
				</div>	
				<input class="form-control" placeholder="price"
					type="text" name="price" id="price">
				</div>
			
			<div class="form-group input-group">
				<div class="input-group-prepend">
					
				</div>
				<input name="des" class="form-control"
					placeholder="product description" type="text" id="des">
				</div>
				
				
				<div class="form-group input-group">
				<div class="input-group-prepend">
					
				</div>	
				<input name="image" class="form-control"
					placeholder="product image" type="file" id="image">
				</div>
			
			<!-- form-group// -->
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block">
					submit</button>
			</div>
			<!-- form-group// -->
		</form>
		<span id="tops"></span>
		</article>
	</div>
</body>
</html>