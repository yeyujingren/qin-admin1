function login() {
	var id = $("#id").val();
	var password = $("#password").val();
	var idResult = false;
	var passwordResult = false;
	if (isNaN(id) || id == "") {
		alert("账号不能为空并且必须全为数字！");
	} else if (id.length > 10) {
		alert("账号长度已经超出账号限定的长度！");
	} else {
		idResult = true;
	}
	if (password == "") {
		alert("密码不能为空！");
	} else {
		passwordResult = true;
	}

	if (idResult == true && passwordResult == true) {

		$.ajax({
		    url : "login",
		    data : JSON.stringify({
		         "id" : id,
		         "password" : password
		    }),
		    traditional : false,
		    type : 'post',
		    cache : false,
		    async: false,
		    dataType : 'json',
		    contentType : 'application/json; charset=UTF-8',
		    success : function(data) {
		        if(data.success == true) {
		        	alert(data.message+",马上前往主页");
		        	window.location.href = "index";
		        }else {
		        	alert(data.message);
		        }
		    },
		    error : function(data) {
		         alert(data.message);
		    }
		});

	}
}