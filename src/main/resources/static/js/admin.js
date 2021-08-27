angular.module('admin', ['ngResource', 'ngRoute'])
.config(function ($routeProvider){
$routeProvider
    .when('/fulllist', {
        templateUrl: 'adminpart/fulllist.html',
 		controller: 'GuestController',
 		controllerAs: 'guestCtr'})
 	.when('/confirm', {
            templateUrl: 'adminpart/confirm.html',
     		controller: 'ConfirmedController',
     		controllerAs: 'confCtr'})
    .when('/declined', {
                templateUrl: 'adminpart/declined.html',
         		controller: 'DeclinedController',
         		controllerAs: 'decCtr'})
    .when('/vaccinated', {
                    templateUrl: 'adminpart/vaccinated.html',
             		controller: 'VaccinatedController',
             		controllerAs: 'vacCtr'})
    .when('/vegetarian', {
                        templateUrl: 'adminpart/vegetarian.html',
                 		controller: 'VegetarianController',
                 		controllerAs: 'vegeCtr'})
     .when('/accommodation', {
                            templateUrl: 'adminpart/accommodation.html',
                     		controller: 'AccommodationController',
                     		controllerAs: 'accCtr'})
    .otherwise({
          redirectTo: '/fulllist'
          });
})
.controller('GuestController', function($http, $resource){
     var vm = this;
         var Guest = $resource('api/admin/:guestId');
         vm.guest = new Guest();
         var GuestDetails = $resource('api/admin/details/:guestLogin');
         vm.details = new GuestDetails();

         function showGuest(){
              vm.guestList = Guest.query(
              function success(data, headers){
                 console.log('Pobrano dane: ' + data);
                 console.log(headers('Content-Type'));
              }, function error (response) {
                  console.log(response.status);
              }
              );
         }

         showGuest();

         vm.loadGuestInfo = function(id){
             vm.guestInfo = Guest.get({guestId: id});
             vm.show = false;
         }

         vm.changeGuestInfo = function(id, login){
             vm.loadGuestInfo(id);
             vm.newGuestInfo = GuestDetails.get({guestLogin: login});
             vm.show = true;
         }



         vm.updateDetails = function(newGuestInfo){
             $http.post('/api/admin', newGuestInfo)
             .then(function success(response) {
                 console.log('send' + newGuestInfo);
             }, function error(response){
                 console.log('Data not saved '+ newGuestInfo);
             });

         }

})
.controller('ConfirmedController', function($http, $resource){
 var vm = this;
     var Guest = $resource('api/admin/confirm/:guestId');
     vm.guest = new Guest();
     var GuestDetails = $resource('api/admin/details/:guestLogin');
     vm.details = new GuestDetails();

     function showGuest(){
          vm.guestList = Guest.query(
          function success(data, headers){
             console.log('Pobrano dane: ' + data);
             console.log(headers('Content-Type'));
          }, function error (response) {
              console.log(response.status);
          }
          );
     }

     showGuest();

     vm.loadGuestInfo = function(id){
         vm.guestInfo = Guest.get({guestId: id});
         vm.show = false;
     }

     vm.changeGuestInfo = function(id, login){
         vm.loadGuestInfo(id);
         vm.newGuestInfo = GuestDetails.get({guestLogin: login});
         vm.show = true;
     }



     vm.updateDetails = function(newGuestInfo){
         $http.post('/api/admin', newGuestInfo)
         .then(function success(response) {
             console.log('send' + newGuestInfo);
         }, function error(response){
             console.log('Data not saved '+ newGuestInfo);
         });

     }

})
.controller('DeclinedController', function($http, $resource){
  var vm = this;
      var Guest = $resource('api/admin/declined/:guestId');
      vm.guest = new Guest();
      var GuestDetails = $resource('api/admin/details/:guestLogin');
      vm.details = new GuestDetails();

      function showGuest(){
           vm.guestList = Guest.query(
           function success(data, headers){
              console.log('Pobrano dane: ' + data);
              console.log(headers('Content-Type'));
           }, function error (response) {
               console.log(response.status);
           }
           );
      }

      showGuest();

      vm.loadGuestInfo = function(id){
          vm.guestInfo = Guest.get({guestId: id});
          vm.show = false;
      }

      vm.changeGuestInfo = function(id, login){
          vm.loadGuestInfo(id);
          vm.newGuestInfo = GuestDetails.get({guestLogin: login});
          vm.show = true;
      }



      vm.updateDetails = function(newGuestInfo){
          $http.post('/api/admin', newGuestInfo)
          .then(function success(response) {
              console.log('send' + newGuestInfo);
          }, function error(response){
              console.log('Data not saved '+ newGuestInfo);
          });

      }

 })
 .controller('VaccinatedController', function($http, $resource){
    var vm = this;
        var Guest = $resource('api/admin/vaccinated/:guestId');
        vm.guest = new Guest();
        var GuestDetails = $resource('api/admin/details/:guestLogin');
        vm.details = new GuestDetails();

        function showGuest(){
             vm.guestList = Guest.query(
             function success(data, headers){
                console.log('Pobrano dane: ' + data);
                console.log(headers('Content-Type'));
             }, function error (response) {
                 console.log(response.status);
             }
             );
        }

        showGuest();

        vm.loadGuestInfo = function(id){
            vm.guestInfo = Guest.get({guestId: id});
            vm.show = false;
        }

        vm.changeGuestInfo = function(id, login){
            vm.loadGuestInfo(id);
            vm.newGuestInfo = GuestDetails.get({guestLogin: login});
            vm.show = true;
        }



        vm.updateDetails = function(newGuestInfo){
            $http.post('/api/admin', newGuestInfo)
            .then(function success(response) {
                console.log('send' + newGuestInfo);
            }, function error(response){
                console.log('Data not saved '+ newGuestInfo);
            });

        }

   })
 .controller('VegetarianController', function($http, $resource){
   var vm = this;
       var Guest = $resource('api/admin/vegetarian/:guestId');
       vm.guest = new Guest();
       var GuestDetails = $resource('api/admin/details/:guestLogin');
       vm.details = new GuestDetails();

       function showGuest(){
            vm.guestList = Guest.query(
            function success(data, headers){
               console.log('Pobrano dane: ' + data);
               console.log(headers('Content-Type'));
            }, function error (response) {
                console.log(response.status);
            }
            );
       }

       showGuest();

       vm.loadGuestInfo = function(id){
           vm.guestInfo = Guest.get({guestId: id});
           vm.show = false;
       }

       vm.changeGuestInfo = function(id, login){
           vm.loadGuestInfo(id);
           vm.newGuestInfo = GuestDetails.get({guestLogin: login});
           vm.show = true;
       }



       vm.updateDetails = function(newGuestInfo){
           $http.post('/api/admin', newGuestInfo)
           .then(function success(response) {
               console.log('send' + newGuestInfo);
           }, function error(response){
               console.log('Data not saved '+ newGuestInfo);
           });

       }

  })
  .controller('AccommodationController', function($http, $resource){
     var vm = this;
         var Guest = $resource('api/admin/accommodation/:guestId');
         vm.guest = new Guest();
         var GuestDetails = $resource('api/admin/details/:guestLogin');
         vm.details = new GuestDetails();

         function showGuest(){
              vm.guestList = Guest.query(
              function success(data, headers){
                 console.log('Pobrano dane: ' + data);
                 console.log(headers('Content-Type'));
              }, function error (response) {
                  console.log(response.status);
              }
              );
         }

         showGuest();

         vm.loadGuestInfo = function(id){
             vm.guestInfo = Guest.get({guestId: id});
             vm.show = false;
         }

         vm.changeGuestInfo = function(id, login){
             vm.loadGuestInfo(id);
             vm.newGuestInfo = GuestDetails.get({guestLogin: login});
             vm.show = true;
         }



         vm.updateDetails = function(newGuestInfo){
             $http.post('/api/admin', newGuestInfo)
             .then(function success(response) {
                 console.log('send' + newGuestInfo);
             }, function error(response){
                 console.log('Data not saved '+ newGuestInfo);
             });

         }

    })
;