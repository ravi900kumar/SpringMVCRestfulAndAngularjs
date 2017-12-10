app
		.service(
				'productService',
				function($http) {
					var promise;
					this.allProducts = function() {

						promise = $http
								.get(
										"http://localhost:8080/SpringMVCRestfulAndAngularjs/product/all/")
								.then(function(response) {

									return response.data;
								});

						return promise;

					};

					this.oneProduct = function(id) {

						promise = $http.get(
								"http://localhost:8080/SpringMVCRestfulAndAngularjs/product/findone/"
										+ id).then(function(response) {
							return response.data;
						});

						return promise;

					};
					this.ProductDelete = function(id) {

						promise = $http
								.post(
										"http://localhost:8080/SpringMVCRestfulAndAngularjs/product/delete/"
												+ id)
								.then(
										function(response) {
											window.location.href = 'http://localhost:8080/SpringMVCRestfulAndAngularjs/index.html#/productslist';
										});

					};

					this.productupdate = function(product) {

						$http
								.post(
										'http://localhost:8080/SpringMVCRestfulAndAngularjs/product/update/',
										product)
								.then(
										function(response) {

											window.location.href = 'http://localhost:8080/SpringMVCRestfulAndAngularjs/index.html#/productslist';
										});

					};
					this.saveProsuct = function(product) {
						$http
								.post(
										'http://localhost:8080/SpringMVCRestfulAndAngularjs/product/create/',
										product)
								.then(
										function(response) {

											window.location.href = 'http://localhost:8080/SpringMVCRestfulAndAngularjs/index.html#/productslist';
										});

					};

				});
