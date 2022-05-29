<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file='../css/style.css' %>
    </style>
</head>
<body>
<c:if test="${empty post.id}">
    <c:set var="id" scope="session" value="0" />
</c:if>
<c:if test="${not empty post.id}">
    <c:set var="id" scope="session" value="${post.id}" />
</c:if>
<form style="width: 50%;" name='login' action="<c:url value='/save?id=${id}'/>" method='POST'>
    <table>
        <tr>
            <td>Name topic:</td>
            <td style="width: 100%"><input class="text-field__input" type='text' name='name' value="${post.name}"></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td style="width: 100%"><p><textarea name='description'>${post.description}</textarea></p></td>
        </tr>
        <tr>
            <td colspan='2'><input class="button" style="float: right;" name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>