<%--
  Created by IntelliJ IDEA.
  User: 鲁靖大大
  Date: 2017/8/3
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html >
<html>
<head>
    <meta charset="UTF-8">
    <title>ssm</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="margin-top:10px">
<h1>Spring MVC+spring +mybatis+mysql</h1>
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
    <tbody>
    <c:forEach var="toy" items="${requestScope.toys}" varStatus="rows">
    <tr>
        <td>${rows.index+1}</td>
        <td>${toy.name}</td>
        <td>${toy.price}</td>
        <td><fmt:formatDate value="${toy.createDate}" pattern="yyyy-MM-dd"/></td>
        <td><button class="btn btn-warning" onclick="modifyToy(${toy.id})">修改</button>&nbsp;&nbsp;
            <button class="btn btn-danger" onclick="removeToy(${toy.id},'${toy.name}')">删除</button>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<script>
    function modifyToy(id) {
        location.href="findById?id="+id;
    }
    function removeToy(id,name) {
        if(confirm("是否删除"+name+"?")){
            location.href="remove?_method=delete&id="+id;
        }
    }
</script>
</body>
</html>
