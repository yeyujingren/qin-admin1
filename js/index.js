function addData(){
    $.ajax({
            url: '',
            type: 'GET',
            dataType: 'json',
            data: $('#form1').serialize(),
            contentType: "application/json; charset=utf-8",
            // timeout: 1000,
            cache: false,
            // bedforeSend: $("#table1").html('加载中...请稍后！'),
            // success: $('form').submit(function () {
            //     alert($(this).serialize());
            //     return false;
            // }),
            success: function (result) {
                // console.log(databack);
                // alert("成功!");
                if(result.resultCode == 200){
                    alert("提交成功！")
                }
                // alert($(this).serialize());
            },

            error: function () {
                console.log("提交失败,请重试!");
                alert("失败了");
            }
        })
    }
        





