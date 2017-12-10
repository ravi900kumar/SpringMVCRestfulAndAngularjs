app.controller('addproductcontroller', function($scope, $routeParams,
		productService) {
	$scope.addproductsmessage = 'New Product  ';
	$scope.addProduct = function(product) {
		productService.saveProsuct(product);
	}

});