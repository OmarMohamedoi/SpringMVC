<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><title>Not Found</title></head>
<body>
    <h1>404 -- Not Found</h1>
    <p><c:out value="${message}"/></p>
    <p><a href="${pageContext.request.contextPath}/tasks">Back to tasks</a></p>
</body>
</html>
