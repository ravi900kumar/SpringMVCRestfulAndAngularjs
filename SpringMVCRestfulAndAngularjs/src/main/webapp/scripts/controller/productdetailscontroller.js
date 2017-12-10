app.controller('productdetailscontroller', function($route, $scope,
		$routeParams, $http, productService) {
	var id = $routeParams.id;
	productService.oneProduct(id).then(function(oneproduct) {
		$scope.productdetailsmessage = 'Product Details ';
		$scope.product = oneproduct;
	});

});