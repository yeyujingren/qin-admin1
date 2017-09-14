    // var json = {};
    $(function () {
        $.ajax({
            url:'https://easy-mock.com/mock/59b94b5ce0dc663341a8f1e5/aha/aha#!method=get',
            type: 'GET',
            dataType: 'json',
            timeout: 1000,
            cache: false,
            bedforeSend: LoadFunction,
            error: erryFunction,
            success: succFunction
        })

        function LoadFunction () {
            $("#list").html('加载中...请稍后！');
        }

        function erryFunction () {
            alert("error")
        }

        function succFunction (data) {
            // var json = eval("(" + data +")");
             console.log(data)
            var table = $('#list').dataTable({
                "data": data.data,
                "columns": [
                {"data": "name"},
                {"data": "location"},
                {"data": "deadline"},
                {"data": "sex"},
                {"data": null}
                ],
                "lengthChange": false,
                "searching": false,
                // "drawCallback": function (settings){
                //     console.log('settings',settings)
                // },
                pageLength: 10,
                "serverSide": false,
                "processing": true,
                // dom: 'B<"clear">lfrtip',
                // buttons: ['copy', 'csv', 'excel'],
                // button: ['copy', 'csv', 'excel'],
                "aaSorting": [[1, "desc"]], 
                "oLanguage": {//插件的汉化
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "抱歉， 没有找到",
                "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                "sInfoEmpty": "没有数据",
                "sInfoFiltered": "(从 _MAX_ 条数据中检索)",

                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "前一页",
                    "sNext": "后一页",
                    "sLast": "尾页"
                        },
                    "sZeroRecords": "没有检索到数据",
                    "sProcessing": "<img src='' />",
                    "sSearch": "搜索"
                    },
                    columnDefs: [{
                        targets: 4,
                        render: function(data,type,row,meta){
                            // console.log('meta',meta)
                            // var i = 0;
                            return '<a type="button" href="#" class="change"  data-toggle="modal" data-target="#myModal">修改</a>&nbsp;&nbsp;&nbsp;<a type="button" id="btn'+ meta.row +'" onclick = "del('+row.id+')" href="#">删除</a>'
                        }

                    }],
                    "rowCallback": function (row, data,index) {
                    // console.log('row',row)
                    // console.log('data', data)
                    // console.log('index', index)
                    // var tr = row.getElementsByTagName('tr')

                    // var a = row.getElementsByTagName('a')
                    // console.log('tr', tr[0])
                    // console.log(a.getElementById)
                    $(row).bind('click',function(){
                        // console.log(data.name)
                        // console.log(data);
                        // $(".input").value = data.name
                        // json = {
                        //     "name": data.name,
                        //     "location": data.location,
                        //     "deadline": data.deadline,
                        //     "sex": data.sex
                        // }
                        // console.log(json.name)
                        $("#id").val(data.id)
                        $("#name").val(data.name)
                        $("#type").val(data.type)
                        $("#location").val(data.location)
                        $("#time").val(data.time)
                        $("#workplace").val(data.workplace)
                        $("#pay").val(data.pay)
                        $("#deadline").val(data.deadline)
                        $("#sex").val(data.sex)
                        $("#grade").val(data.grade)
                        $("#place").val(data.place)
                        $("#need").val(data.need)
                        // $("#pay").val(data.pay)
                        // console.log(input)
                        // input = data.name;
                        // console.log(1)
                        // console.log($(".xiugai"))
                    })
                    // $(row).bind('click', function () {
                    //     console.log(this)
                    //     console.log(data)
                    //     $.ajax({})
                    // }
                },

                    // "rowCallback": function( row, data ) {//添加单击事件，改变行的样式
                    //     if ( $.inArray(data.DT_RowId, selected) !== -1 ) {
                    //         $(row).addClass('selected');
                    //     }
                    // },
                    "lengthMenu": [[5, 10, 25, 50, -1], [5, 10, 25, 50, "全部"]]
                // buttons: {
                //     buttons: [
                //         'copy',
                //         {
                //             extend: 'excel',text: '删除'
                //         }
                //     ]
                // } 

            });


            
            

            // upDate();
            // $("#list").html('')
            // console.log(data)
            // $.each(data.data.list,function (item,index) {
            // 	// var name = list['name'];
            // 	// console.log(index.name);

            // 	// var name = 	json[index].name
            // 	$("#list").html($("#list").html()+"</br>" + index.name);
            // });

            //$.each(data.data.list,function (item,index) {

                // console.log('shanchu', shanchu)
                // $("#list").html($("#list").html()+ "<tr><th>"
                //     + index.name +
                //     "</th><th>"
                //     + index.location +
                //     "</th><th> "
                //     +index.deadline+
                //     "</th><th>"
                //     + index.sex +
                //     "</th><th><button class = 'btn btn-info' data-toggle='modal' data-target='#myModal'>修改</button>&nbsp;<button class='btn btn-danger shanchu' onclick='shanchu()'>删除</button>"
                    // 		"<div calss='modal fade' id='myModal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>"+
                    // "<div class='modal-dialog'>"+
                    //       "<div class='modal-content'>"+
                    //           "<div class='modal-header'>"+
                    //               "<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button>"+
                    //               "<h4 class='modal-title' id='myModalLabel'>模态框（Modal）标题</h4>"+
                    //           "</div>"+
                    //           "<div class='modal-body'>在这里添加一些文本</div>"+
                    //           "<div class='modal-footer'>"+
                    //               "<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>"+
                    //               "<button type='button' class='btn btn-primary'>提交更改</button>"+
                    //           "</div></div><!-- /.modal-content --></div><!-- /.modal --></div>"

            // })


        };


    })
    // function upDate (){

    //             // console.log(1)
    //             // console.log(json.response.docs[0].index)
    //             console.log(json)
    //         }
    //         upDate()
       // function foo(data,aha){
       //      console.log('success',aha)

       //      var td = document.getElementsByTagName('td')
       //      console.log(td[0])
       //      for(var i =0;i<td.length;i++){

       //      }
       //  }
function login () {
    // console.log(data.id)
    $.ajax({
        type:"POST",
        dataType: "json",
        url: "https://easy-mock.com/mock/59b4b1dee0dc663341a3c6e2/mobile/getData",
        data: {
            "id": $("#id").val(),
            "name": $("#name").val(),
            "people": $("#people").val(),
            "time": $("#time").val(),
            "title": $("title").val(),
            "type": $("#type").val(),
            "location": $("#location").val(),
            "time": $("#time").val(),
            "workplace": $("#workplace").val(),
            "pay": $("#pay").val(),
            "deadline": $("#deadline").val(),
            "sex": $("#sex").val(),
            "grade":$("#grade").val(),
            "place": $("#place").val(),
            "need": $("#need").val()
        },
        // data: {ksbh: $("#name").val()},
        success: function (result) {
            if(result.resultCode == 200) {
                // window.location.reload()
                alert("提交成功！")
            }
        },
        error: function(){
            alert("提交失败，请稍后在试")
            // console.log($("#upDate").serialize())
        }
    })
}
function del (id){
    // console.log(id)
    $.ajax({
        url:"/deleteBringInfo",
        data: {
            id: id
        },
        success: function(msg) {
                    if(data.flag){
                        table.ajax.reload(null,false);
                        alert(name + data.msg)
                    }
            // $("#btn"+meta.row).parent().parent().remove()
            // DataTable.Rows.Remove(DataRow)
        },
        error: function(){
            alert("删除失败，请稍后重试！")
        }
    })
}