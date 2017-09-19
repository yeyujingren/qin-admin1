window.onload = function() {
	var html = "<div class = ></div>";
	$.ajax({
		url : '/getBringInfo',
		type : 'POST',
		dataType : 'json',
		timeout : 1000,
		cache : false,
		bedforeSend : LoadFunction,
		error : erryFunction,
		success : succFunction
	})

	function LoadFunction() {
		$("#list").html('加载中...请稍后！');
	}

	function erryFunction() {
		alert("error")
	}

	function succFunction(data) {
		var table = $('#list')
				.dataTable(
						{
							"data" : data.data,
							"columns" : [{
								"data" : "title"
							},{
								"data" : "location"
							},{
								"data" : "deadline"
							},{
								"data" : "people"
							},{
								"data" : null
							} ],
							"lengthChange" : true,
							"searching" : false,
							"pageLength" : 10,
							"serverSide" : false,
							"processing" : true,
							"ordering":false,
							"oLanguage" : {// 插件的汉化
								"sLengthMenu" : "每页显示 _MENU_ 条记录",
								"sZeroRecords" : "抱歉， 没有找到",
								"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
								"sInfoEmpty" : "没有数据",
								"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",

								"oPaginate" : {
									"sFirst" : "首页",
									"sPrevious" : "前一页",
									"sNext" : "后一页",
									"sLast" : "尾页"
								},
								"sZeroRecords" : "没有检索到数据",
								"sProcessing" : "<img src='' />",
								"sSearch" : "搜索"
							},
							columnDefs : [ {
								targets : 4,
								render : function(data, type, row, meta) {

									return '<a type="button" href="#" class="change"  data-toggle="modal" data-target="#myModal">修改</a>&nbsp;&nbsp;&nbsp;<a type="button" id="btn'
											+ meta.row
											+ '" onclick="del('
											+ row.id + ')" href="#">删除</a>'
								}

							} ],
							"rowCallback" : function(row, data, index) {

								$(row).bind('click', function() {

									$("#id").val(data.id)
									$("#title").val(data.title)
									$("#name").val(data.name)
									$("#people").val(data.people)
									$("#type").val(data.type)
									$("#location").val(data.location)
									$("#workplace").val(data.workplace)
									$("#worktime").val(data.worktime)
									$("#pay").val(data.pay)
									$("#deadline").val(data.deadline)
									$("#sex").val(data.sex)
									$("#grade").val(data.grade)
									$("#place").val(data.place)
									$("#need").val(data.need)

								})

							},

							"lengthMenu" : [ [ 5, 10, 25, 50, -1 ],
									[ 5, 10, 25, 50, "全部" ] ]

						});
		
	}

}

function update() {
	var titleResult = false;
	var nameResult = false;
	var typeResult = false;
	var locationResult = false;
	var worktimeResult = false;
	var workplaceResult = false;
	var payResult = false;
	var deadlineResult = false;
	var gradeResult = false;
	var placeResult = false;
	var needResult = false;

	var peopleResult = false;
	titleResult = checkString('标题', "title", 30);
	nameResult = checkString('招聘职位', "name", 20);
	typeResult = checkString('单位类型', "type", 10);
	locationResult = checkString('单位地址', "location", 50);
	worktimeResult = checkString('工作时间', "worktime", 30);
	workplaceResult = checkString('工作地点', "workplace", 50);
	payResult = checkString('工作报酬', "pay", 8);
	deadlineResult = checkString('截止时间', "deadline", 10);
	peopleResult = checkNumber('招聘人数', "people", 8);
	gradeResult = checkString('年级要求', "grade", 10);
	placeResult = checkString('校区要求', "place", 10);
	needResult = checkString('具体要求', "need", 200);

	if (nameResult == false || titleResult == false || typeResult == false
			|| locationResult == false || worktimeResult == false
			|| workplaceResult == false || payResult == false
			|| deadlineResult == false || peopleResult == false
			|| gradeResult == false || placeResult == false
			|| needResult == false) {

	} else {

		$.ajax({
			url : "updateBringInfo",
			data : JSON.stringify({
				"id" : $("#id").val(),
				"name" : $("#name").val(),
				"title" : $("#title").val(),
				"type" : $("#type").val(),
				"worktime" : $("#worktime").val(),
				"location" : $("#location").val(),
				"workplace" : $("#workplace").val(),
				"pay" : $("#pay").val(),
				"deadline" : $("#deadline").val(),
				"sex" : $("#sex").val(),
				"grade" : $("#grade").val(),
				"place" : $("#place").val(),
				"need" : $("#need").val(),
				"people" : $("#people").val()
			}),
			traditional : false,
			type : 'post',
			cache : false,
			async : false,
			dataType : 'json',
			contentType : 'application/json; charset=UTF-8',
			success : function(result) {
				if (result.success) {
					alert("提交成功！")
					location.reload();
				}
			},
			error : function() {
				alert("提交失败，请稍后在试")
			}
		})
	}
}
function del(id) {
	$.ajax({
		url : "deleteBringInfo",
		data : JSON.stringify({
			"id" : id
		}),
		traditional : false,
		type : 'post',
		cache : false,
		async : false,
		dataType : 'json',
		contentType : 'application/json; charset=UTF-8',
		success : function(data) {
			if (data.success == true) {
				// 登录成功，页面跳转
				// window.location.href = loginAndRegister.URL.loginSuccess();
				alert(data.message);
				window.location.href = "manage";
			} else {
				alert(data.message);
			}
		},
		error : function() {
			alert("删除失败，请稍后重试！")
		}
	})
}
function checkNumber(name, object, limitLength) {


	if (/\D/.test(document.getElementById(object).value)) {
		alert(name + '只能输入数字!');
		document.getElementById(object).value = '';
		return false;
	} else if (document.getElementById(object).value.length == 0) {
		alert(name + '不能为空'  + '!');

		return false;
	} else if (document.getElementById(object).value.length > limitLength ||document.getElementById(object).value.length<0) {
		alert(name + '长度必须小于' + limitLength + '且不小于0!');
		document.getElementById(object).value = '';
		return false;
	} else {
		return true;
	}
}
function checkString(name, object, limitLength) {

	if (document.getElementById(object).value.length > limitLength) {
		alert(name + '长度必须小于' + limitLength + '!');
		document.getElementById(object).value = '';
		return false;
	} else if (document.getElementById(object).value.length == 0) {
		alert(name + '不能为空'  + '!');

		return false;
	} else {
		return true;
	}
}