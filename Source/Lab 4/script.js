var app = angular.module('MyApp', []);
app.controller('MyCont', function($scope, $http){
  
    // Initialization of the scope variables. 
 
    $scope.cityName = "Your City";
    $scope.tmp = 0;
    $scope.minTemp = 0;
    $scope.maxTemp = 0;
 
    // Logic for the On-Click event.
 
    $scope.funGet = function(){
        var url = "http://api.openweathermap.org/data/2.5/weather?q=" + $scope.cityName +"&appid=44db6a862fba0b067b1930da0d769e98" ;
        $http.get(url)
        .success(function(response) {
            $scope.imgWidth = 150;
            $scope.imgHeight = 150;
            $scope.wtData = response.coord;
            $scope.ct = response.name;
            $scope.tmp = response.main.temp - 272.15;
            $scope.hmdy = response.main.humidity;
            $scope.imgCode = response.weather[0].icon;
        });
     }
});

var app = angular.module('MyApp1', []);
app.controller('MyCont1', function($scope, $http){
  
    // Initialization of the scope variables. 
 
    $scope.cityName = "Your City";
    $scope.tmp = 0;
    $scope.minTemp = 0;
    $scope.maxTemp = 0;
 
    // Logic for the On-Click event.
 
    $scope.funGet = function(){
        var url = "http://api.openweathermap.org/data/2.5/weather?q=" + $scope.cityName +"&appid=44db6a862fba0b067b1930da0d769e98" ;
        $http.get(url)
        .success(function(response) {
            $scope.imgWidth = 150;
            $scope.imgHeight = 150;
            $scope.wtData = response.coord;
            $scope.ct = response.name;
            $scope.tmp = response.main.temp - 272.15;
            $scope.hmdy = response.main.humidity;
            $scope.imgCode = response.weather[0].icon;
        });
     }
});

var app = angular.module('GoogleDirection', []);
app.controller('googlemapoutput', function ($scope, $http) {

    var map;
    var mapOptions;
    var directionsDisplay = new google.maps.DirectionsRenderer({
        draggable: true
    });
    var directionsService = new google.maps.DirectionsService();

    $scope.initialize = function () {
          var pos = new google.maps.LatLng(0, 0); 
          var mapOptions = {
                zoom: 3,
                center: pos
            };

            map = new google.maps.Map(document.getElementById('map-canvas'),
            mapOptions);
     };
    $scope.calcRoute = function () {
       var end = document.getElementById('endlocation').value;
            var start = document.getElementById('startlocation').value;

            var request = {
                origin: start,
                destination: end,
                travelMode: google.maps.TravelMode.DRIVING
            };

            directionsService.route(request, function (response, status) {
                if (status == google.maps.DirectionsStatus.OK) {
                    directionsDisplay.setMap(map);
                    directionsDisplay.setDirections(response);
                    console.log(status);
                }
           
        });
    };

    google.maps.event.addDomListener(window, 'load', $scope.initialize);

});
