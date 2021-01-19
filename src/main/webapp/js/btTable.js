$(function(){

    load();


})

function reLoad(){
    $("#myTable").bootstrapTable("refresh");
}

function load(){
    let url="http://localhost:8080/07-Blog/blogSelect"
    $("#myTable").bootstrapTable({
        url:url,
        method:'POST',
        dataType:"JSON",

        striped:true,//是否显示隔行换色
        pageNumber:1,//初始化加载第一页
        pagination:true,//是否分页
        sidePagination:'server',
        pageSize:2,//每页记录数
        //查询时携带的参数  data：JSON.stringify()
        queryParams:function(params){
            var temp={
                offset:params.offset,
                pageNumber:params.limit
            };
            return JSON.stringify(temp);
        },
        columns:[
            {
                title:'行号',
                align:"center",//水平居中
                halign:"center",//垂直居中
                formatter:function(value,row,index){
                    return index+1;
                }
            },
            {
                title:'bid',
                field:'bid'

            },
            {
                title:'标题',
                field:'btitle',

            },
            {
                title:'发布时间',
                field:'bdate'
            },


            {
                title:'操作',
                formatter:function(value,row,index){
                    /*let url= 'http://localhost:8080/SpringMVC_1/removeData/'+index;*/
                    let deleteRow='<a href="javascript:query(\''+row.bid+'\')">查详情</a>';





                   /* let update="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:remove(\'"+url+"\')'>修改</a>";*/

                    return deleteRow;
                }
            }
            /*,
            {
                title:'操作2'
            }*/
        ],
        onDblClickRow:function(row, $element){
            console.log(row);
            console.log($element.innerHTML);
            // console.log(field)
        }
    });
}



function query(bid){

    var jsondata={};
    jsondata.bid=bid;
    $.ajax({
        url:"http://localhost:8080/07-Blog/queryDetail1",
        type:"post",
        data:jsondata,
        dataType: "json",
        success:function(result){

            if(result.mark==1){
                window.location.href="detail.html"
            }else if(result.mark==0){

            }
        }



    });

}