app.controller('productlistController', function($scope, $routeParams,
		$interval, productService) {
	var c = 0;
	// $scope.allproductslist =  	productService.allProducts();

	var timer = $interval(function() {
		$scope.allproductsmessage = 'Products List ';

		productService.allProducts().then(function(allproducts) {
			$scope.allproductslist = allproducts;
		});
		c++;
		if (c === 50) {
			$scope.message = "Restarting the timer again :-)";
			c = 0;
		}
	}, 1000);

});
