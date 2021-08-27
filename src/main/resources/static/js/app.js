angular.module('app', ['ngRoute', 'ngResource'])
.config(function ($routeProvider){
$routeProvider
    .when('/welcome', {
        templateUrl: 'partials/welcome.html',
 		controller: 'WelcomeController',
 		controllerAs: 'welCtrl'})
    .when('/details', {
        templateUrl: 'partials/details.html',
 		controller: 'DetailsController',
 		controllerAs: 'detCtrl'})
 	.when('/ceremony', {
 	    templateUrl: 'partials/ceremony.html',
        controller: 'CeremonyController',
        controllerAs: 'cerCtrl'
 		})
 	.when('/party', {
     	templateUrl: 'partials/party.html',
        controller: 'PartyController',
        controllerAs: 'partyCtrl'
     	})
     .when('/photos', {
          	templateUrl: 'partials/photos.html',
             controller: 'PhotosController',
             controllerAs: 'photoCtrl'
          	})
     .otherwise({
     redirectTo: '/welcome'
     });
 		})
 	.controller('WelcomeController', function($http){

        var vm = this;
         $http.get('api/guest')
             .then(function success(response) {
                  vm.guest = response.data;
                  console.log('http action');
              }, function error(response) {
                   console.log('API error ' + response.status);
               });

        })
 	.controller('DetailsController', function($http){

    var vm = this;

    $http.get('api/guest/wedding')
                                .then(function success(response) {
                                       vm.weddingConfirm = response.data;
                                       console.log('http action');
                                       }, function error(response) {
                                       console.log('API error ' + response.status);
                                       	});

    $http.get('api/guest/secondday')
                                    .then(function success(response) {
                                           vm.secondDayConfirm = response.data;
                                           console.log('http action');
                                           }, function error(response) {
                                           console.log('API error ' + response.status);
                                           	});

    $http.get('api/guest/menu')
                                    .then(function success(response) {
                                           vm.menuChoice = response.data;
                                           console.log('http action');
                                           }, function error(response) {
                                           console.log('API error ' + response.status);
                                           	});


 	})
 	.controller('CeremonyController', function(){})
 	.controller('PartyController', function(){})
 	.controller('PhotosController', function(){})
 	;
