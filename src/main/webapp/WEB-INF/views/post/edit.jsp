<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:if test="${empty post.id}">
    <c:set var="id" scope="session" value="0" />
</c:if>
<c:if test="${not empty post.id}">
    <c:set var="id" scope="session" value="${post.id}" />
</c:if>
<form name='login' action="<c:url value='/save?id=${id}'/>" method='POST'>
    <table>
        <tr>
            <td>name:</td>
            <td><input type='text' name='name' value="${post.name}"></td>
        </tr>
        <tr>
            <td>description:</td>
            <td><input type='text' name='description' value="${post.description}"/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>