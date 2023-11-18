<%@ page import="bs.Entity.People" %>
<%@ page import="bs.Server.JDBC" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>查看联系人信息</title>

    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
    <%
        List<People> People =JDBC.query();
        request.setAttribute("people", People);%>

    <div class="container" >
        <h3 >通讯录列表</h3>
        <div style="text-align: center">
            <form id="form"  method="post" >
                <table bgcolor="aqua"  class="table table-bordered table-hover" style="text-align: center">
                    <tr class="success" >
                        <th >姓名</th>
                        <th>电话</th>
                    </tr>
                    <c:forEach items="${pb}" var="people" varStatus="s">
                        <tr>
                            <td>${people.name}</td>
                            <td>${people.phone}</td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
