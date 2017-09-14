function IbtnEnter_onclick() {
    checklogin();
    return false;
}

function checklogin() {
    if ($("#TxtUserName").val() == "") {
        alert("用户名不能为空！");
        $("#TxtUserName").focus();
        return false;
    }
    if ($("#TxtPassword").val() == "") {
        alert("密码不能为空！");
        $("#TxtPassword").focus();
        return false;
    }
    $.ajax({
        type: "POST",
        url: "ajax/Handler.ashx?M=" + Math.random(),
        data: "username=" + $("#TxtUserName").val().toString() + "&pwd=" + $("#TxtPassword").val().toString(),
        success: function (data) {
            if (data == "1") {
                location.href = "index.aspx";
                return true;
            }
            else {
                alert("请确认您输入的用户名或密码输入是否正确！");
                $("#TxtUserName").val("");
                $("#TxtPassword").val("");
                $("#TxtUserName").focus();
                return false;
            }
        }

    })
}
