var app = angular.module('myapp', [ 'ngRoute' ]);

app.config(function($routeProvider) {
	$routeProvider.when('/', {
		controller : 'homeController',
		templateUrl : 'views/home.html'
	});

	$routeProvider.when('/productslist', {
		controller : 'productlistController',
		templateUrl : 'views/productslist.html'
	});

	$routeProvider.when('/addproduct', {
		controller : 'addproductcontroller',
		templateUrl : 'views/addproduct.html'
	});

	$routeProvider.when('/productedit/:id', {
		controller : 'editproductcontroller',
		templateUrl : 'views/editproduct.html'
	});

	$routeProvider.when('/productdetails/:id', {
		controller : 'productdetailscontroller',
		templateUrl : 'views/productdetails.html'
	});

	$routeProvider.when('/productdelete/:id', {
		controller : 'productdeletecontroller',
		templateUrl : 'views/productslist.html'

	});

	$routeProvider.otherwise({
		redirectTo : '/'
	});
});
