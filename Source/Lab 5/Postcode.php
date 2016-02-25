<!doctype html>
<html>
<head>
    <title>What's my Postcode</title>

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
					<p class = "lead center ">Enter any address to find post code and temperature </p>
				<form>
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "address" id = "address" 
						placeholder = "eg: 5318 Rockhill Rd"/>
					</div>
				<button id = "findMyPostcode" class = "btn btn-success btn-lg "> Find my Postcode </button>
				<button id = "findMyTemperature" class = "btn btn-success btn-lg "> Find Temperature </button>
				</form>

				<div id = "success"class = "alert alert-success">Success!</div>
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
		type:"GET";
		url:
		"https://maps.googleapis.com/maps/api/geocode/xml?address="+$("#address").val()+"&key=AIzaSyDDhlCgDQ1noWlePvLCiXO4xOPjE82awko",
		dataType:"xml";
		success:processXML


	});
	function process(xml){
		$(xml).find("address_cmponent").each(funcion()){
			if ($(this).find("type").text()=="postal_code"){
				$("#success").html("Postal code is "+$(this).find('long_name').text().fadeIn()+"°C");
			}
		});
	}
   
	
	
});

</script>

</body>
</html>