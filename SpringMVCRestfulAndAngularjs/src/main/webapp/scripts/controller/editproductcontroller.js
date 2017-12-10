app.controller('editproductcontroller', function($route, $scope, $routeParams,
		$http, productService) {
	var id = $routeParams.id;
	productService.oneProduct(id).then(function(oneproduct) {
		$scope.editproductsmessage = 'Edit Product';
		$scope.product = oneproduct;
	});

	$scope.updateProduct = function(product) {
		productService.productupdate(product);
	}

});