<!doctype html>
<html>
<head>
    <title>Temperature-Postcode Mashup</title>

    <meta charset="utf-8" />
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
   
   <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<style>

	html,body{
		height:100%;		
	}
	.container{
		background-image:url("bg.jpg");
		width:100%;
		height:100%;
		background-size:cover;
		background-position: center;
		padding-top: 25px;
	}


	.center{
		text-align: center;

	}

	.white{
		color:white;
	}
	p{
		padding-top: 15px;
		padding-bottom:15px;
	}

	button{
		margin-top: 20px;
		margin-bottom: 20px;
	}

	.alert{
		margin-top: 20px;
		display:none;
	
	}
	.whiteBackground{
		background-color:white;
		padding:20px;
		border-radius:20px;
	}
	</style>

 </head>

<body>

	<div class = "container">

			<div class = "row">

				<div class = "col-md-6 col-md-offset-3 center whiteBackground">
					<h1 class = "center ">  Temperature-Postcode Mashup</h1>
					<p class = "lead center ">Enter any address to find the post code and temperature </p>
				<form>
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "address" id = "address" 
						placeholder = "eg: 5318 Rockhill Rd, Kansas City"/>
					</div>
				<button id = "findMyPostcode" class = "btn btn-success btn-lg "> Find my Postcode and Temperature </button>
				</form>

				<div id = "success"class = "alert alert-success">Success!</div>
				<div id = "forecast"class = "alert alert-success">Success!</div>
				<div id = "fail" class = "alert alert-danger">Enter a valid city </div>
					
				<div id = "nocity" class = "alert alert-danger">Please enter a city </div>
				
			
				
				</div>

			


			</div> 
	</div>
	
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script>

	$("#findMyPostcode").click(function(event){
        event.preventDefault();
        $.ajax({
                type: "GET",
                url: "http://api.openweathermap.org/data/2.5/weather?q="+$(address).val()+"&mode=xml&units=metric&appid=4eb2151c6a4989e9de093a92c18373a6" ,
                dataType: "xml",
                success: processXML
              }); 

        function processXML(xml) {
	                    $("#forecast").fadeIn();
						$("#forecast").html("The temperature is "+$(xml).find('temperature').attr("value")+"°C");
        }               
   });

    $("#findMyPostcode").click(function(event){
        event.preventDefault();
        $.ajax({
                type: "GET",
                url: "https://maps.googleapis.com/maps/api/geocode/xml?address="+$(address).val()+"&key=AIzaSyDuLt7iWOzVF1AeqjXAMOLzRcGbALzfiVk",
                dataType: "xml",
                success: processXML
              }); 

        function processXML(xml) {
             $(xml).find("address_component").each(function(){
	                    if ($(this).find("type").text()=="postal_code"){
	                    $("#success").fadeIn();
						$("#success").html("The postcode you need is "+$(this).find('long_name').text());}
	                });

        }               
   });
   
   

</script>

</body>
</html>