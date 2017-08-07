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
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<c:if test="${!empty toy}">
    <h2>修改</h2>
    <form action="save"  name="f" role="formRole">
        <div class="form-group">
            <label>玩具名</label>
            <input type="hidden" name="_method" value="put">
            <input type="hidden" name="id" value="${toy.id}">
            <input type="text" class="form-control" name="name" placeholder="玩具名" value="${toy.name}"  required>
            <small style="color: red">*</small>
        </div>
        <div class="form-group">
            <input type="number" step="0.01" name="price" class="form-control" placeholder="价格" value="${toy.price}">
        </div>

        <div class="form-group">
            <input type="date"  name="createDate" class="form-control"  value="<spring:eval expression="toy.createDate"/>">
        </div>

        <button type="submit" class="btn btn-primary">保存</button>

    </form>
</c:if>
<c:if test="${empty toy}">
    <h2>新增</h2>
   <form action="save" method="post" name="f" role="formRole">
       <div class="form-group">
           <label>玩具名</label>
           <input type="hidden" name="id" >
           <input type="text" class="form-control" name="name" placeholder="玩具名"  required>
           <small style="color: red">*</small>
       </div>
       <div class="form-group">
           <input type="number" step="0.01" name="price" class="form-control" placeholder="价格" >
       </div>

       <div class="form-group">
           <input type="date"  name="createDate" class="form-control"  >
       </div>

        <button type="submit" class="btn btn-primary">保存</button>

   </form>
</c:if>
</div>
</body>
</html>