<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Big Title</h1>

<table border="1" cellpadding="6">

        <tr><th>Title</th><th>Priority</th><th>Completed</th></tr>
    <tr>
        <c:forEach var="task" items="${tasks}">
                    <td><a href="${pageContext.request.contextPath}/tasks/${task.id}"><c:out value="${task.title}"/></a></td>
                    <td><c:out value="${task.priority}"/></td>
                    <td><c:out value="${task.completed}"/></td>



    </tr>
    </c:forEach>
</table>
</body>
</html>