 

function addData() {
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
	titleResult = checkString('单位名称', "title", 30);
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
			url : '/insertBringInfo',
			data : JSON.stringify({
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
			success : function(data) {
				if (data.success == true) {

					alert(data.message);
				} else {
					alert(data.message);
				}
			},
			error : function() {
				alert("添加失败");
			}
		})
	}
}
function checkNumber(name, object, limitLength) {

	if (/\D/.test(document.getElementById(object).value)) {
		alert(name + '只能输入数字!');
		document.getElementById(object).value = '';
		return false;
	} else if (document.getElementById(object).value.length == 0) {
		alert(name + '不能为空' + '!');

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
		alert(name + '不能为空' + '!');

		return false;
	} else {
		return true;
	}
}