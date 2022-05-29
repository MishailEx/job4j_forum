<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Форум</title>
    <style>
        <%@include file='../css/style.css' %>
    </style>
</head>
<body>
<div class="container mt-3">
    <div>
        <h4 style="text-align: center">Forum</h4>
    </div>
    <tr class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Тема - ${post.name}</th>
                <th style="text-align: center; width: 15%">
                    <a href="<c:url value='/edit?id=${post.id}'/>">Изменить</a></th>
                <th style="width: 15%; text-align: center" scope="col">
                    <fmt:formatDate value='${post.created}' type='time' pattern='yyyy-MM-dd'/></th>
            </tr>
            </thead>
            <tbody>
            <tr>
               <td colspan="3" style="background: #eae6e6">${post.description}</td>
            </tr>
            <c:forEach items="${messages}" var="message">
                <tr>
                    <td>${message.text}</td>
                    <td style="text-align: center">${message.userName}</td>
                    <td style="text-align: center"><fmt:formatDate value='${message.created}' type='time' pattern='hh:mm:ss dd-MM-yy'/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form name='mess' action="<c:url value='/send?id=${post.id}'/>" method='POST'>
            <p><textarea name="message" placeholder="Введите ваше сообщение:"></textarea></p>
            <p><input class="button" type="Submit"></p>
        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>