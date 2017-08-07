<%--
  Created by IntelliJ IDEA.
  User: 鲁靖大大 哈哈哈
  Date: 2017/8/4
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html>
<head>
    <meta charset="UTF-8">
    <title>ssmm</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Spring MVC+spring +mybatis+mysql</h1>
<h2>ssmm restfulban</h2>
<div class="container" style="margin-top:10px">
    <form action="list" method="get" name="f" role="formRole">
        <div class="form-group">
            <input type="text" name="name" placeholder="玩具名" class="form-control">
        </div>
        <div class="form-group">
            <input type="date" class="form-control" name="beginDate">
        </div>
        <div class="form-group">
            <input type="date" class="form-control" name="endDate">
        </div>
        <button type="submit" class="btn btn-primary btn-block">查询</button>
    </form>

    <a href="edit.jsp">新增</a>
    <table class="table table-striped table-hover">
        <caption>toy crud</caption>
        <thead>
        <tr>
            <th>序号</th>
            <th>玩具名</th>
            <th>价格</th>
            <th>生产日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="tbody">

            <tr>
                <td>1</td>
                <td>兔</td>
                <td>20</td>
                <td>2017-05-02</td>
                <td><button class="btn btn-warning" id="btnModify">修改</button>&nbsp;&nbsp;
                    <button class="btn btn-danger" id="btnRemove">删除</button>
                </td>
            </tr>

        </tbody>
    </table>
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.2.js"></script>
<script>
    $(function () {
        $.ajax({
            type:"GET",
            url:"toy",
            data:{},
            dataType:"json",
            success:function (data) {
                //alert(data);
                $.each(data,function (i) {
                    var btn="<button class=\"btn btn-warning\" onclick=\"findById("+data[i].id+")\">修改</button>&nbsp;&nbsp; <button class=\"btn btn-danger\" onclick=\"remove("+data[i].id+','+"'"+data[i].name+"'"+")\">删除</button>"
                    var text="<tr>";
                    text+="<td>"+(i+1)+"</td>";
                    text+="<td>"+data[i].name+"</td>";
                    text+="<td>"+data[i].price+"</td>";
                    text+="<td>"+data[i].createDate+"</td>";
                    text+="<td>"+btn+"</td>";
                    text+="</tr>";
                    $("#tbody").append(text);
                })
            },
            error:function (msg) {
                console.log("与服务器断开连接",msg)
            }
        })
    })
    function findById(id) {
        alert(id);
    }
    function remove(id,name) {
        alert(id+name);
    }
</script>
</body>
</html>