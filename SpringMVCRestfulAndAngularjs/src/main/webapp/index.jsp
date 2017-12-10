<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="myapp">
<head>
<meta charset="UTF-8">
<title>Angular Js</title>

</head>
<body ng-controller="homeController">
	<div align="center">
		<a href="#/">Home</a> | <a href="#/productslist">Products List</a> | <a
			href="#/addproduct">Add Product</a>

		<div ng-view></div>

		<h1>java9r.com</h1>

	</div>
	<script type="text/javascript" src="scripts/js/angular.min.js"></script>
	<script type="text/javascript" src="scripts/js/angular-route.min.js"></script>
	<script type="text/javascript" src="scripts/app.js"></script>
	<script type="text/javascript"
		src="scripts/controller/homeController.js"></script>
	<script type="text/javascript"
		src="scripts/controller/editproductcontroller.js"></script>
	<script type="text/javascript"
		src="scripts/controller/productdetailscontroller.js"></script>
	<script type="text/javascript"
		src="scripts/controller/productdeletecontroller.js"></script>

	<script type="text/javascript"
		src="scripts/controller/productlistController.js"></script>

	<script type="text/javascript"
		src="scripts/controller/addproductcontroller.js"></script>

	<script type="text/javascript" src="scripts/services/productService.js"></script>
</body>
</html>
