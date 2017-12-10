app.controller('productdeletecontroller', function($route, $scope,
		$routeParams, $http, productService) {
	var id = $routeParams.id;
	productService.ProductDelete(id);

});