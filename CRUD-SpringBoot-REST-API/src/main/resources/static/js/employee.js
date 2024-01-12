var baseUrl= "";
function setBaseUrl(url){
	//swal(url);
	baseUrl = url;
}


function submitForm(){
	this.event.preventDefault();
	
	let employee = {};
	
	employee["name"] = $("#name").val();
	employee["email"] = $("#email").val();
	employee["contact"] = $("#contact").val();
	employee["address"] = $("#address").val();
	employee["department"] = $("#department").val();
	
	submitFormToServer(employee);
	
	
	
	
}

function submitFormToServer(data){
	
	let url = baseUrl + '/api/save-employee';
	
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: url,
		data: JSON.stringify(data),
		dataType: "json",
		success: function(result){
			console.log(result);
			swal(`${result.message}`);
			setTimeout(function(){
				window.location.href = '/';
			}, 2000);
			
			
		},
		error:function(e){
			console.log("ERROR: ", e);
			swal(`${e}`);
		}
		
	});
	
}