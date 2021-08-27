angular.module('det', [])
.controller('ConfirmWeddingController', function($http){

	var vm = this;
 	$http.get('api/guest')
                            .then(function success(response) {
                                   vm.guest = response.data;
                                   console.log('http action');
                                   }, function error(response) {
                                   console.log('API error ' + response.status);
                                   	});




this.headerWedding = 'Niestety nie';
this.changeWedding = function(headerWedding){
this.headerWedding = this.newDetails.confirm? 'Tak!': 'Niestety nie'
}

vm.updateDetails = function(newDetails){

    $http.post('api/guest/setdetails', newDetails)
    .then(function success(response) {
        console.log('send' + newDetails);
    }, function error(response){
        console.log('Data not saved '+ newDetails);
    });

}

 this.headerSecondDay = 'Niestety nie';
 this.changeSecondDay = function(){
 this.headerSecondDay = this.newDetails.secondDay? 'Tak!': 'Niestety nie'
 }




 })
 ;
