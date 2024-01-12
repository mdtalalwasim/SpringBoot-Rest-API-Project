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

function submitFormToServer(employee){
	
	let url = baseUrl + '/api/save-employee';
	
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: url,
		data: JSON.stringify(employee),
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




function submitEditForm(){
	this.event.preventDefault();
	
	let employee = {};
	let id = $("#id").val();
	//alert("submitEditForm :"+id);
	//alert("Id submitEditForm :"+id);
	employee["id"] = id;
	employee["name"] = $("#name").val();
	employee["email"] = $("#email").val();
	employee["contact"] = $("#contact").val();
	employee["address"] = $("#address").val();
	employee["department"] = $("#department").val();
	
	submitEditFormToServer(employee, id);
	
	
	
	
}

function submitEditFormToServer(employee, id){
	//alert("submitEditFormToServer "+id);
	let url = baseUrl + '/api/update-employee/'+id;
	//alert(url);
	$.ajax({
		type: "PUT",
		contentType: "application/json",
		url: url,
		data: JSON.stringify(employee),
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

