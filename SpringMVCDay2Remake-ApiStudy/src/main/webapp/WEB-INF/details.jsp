<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task Details</title>
</head>
<body>
    <h1>Big Title</h1>

    <h2>TASK DETAILS</h2>

    <p>Task name: <strong>${task.title}</strong></p>
    <p>Priority: ${task.priority}</p>
    <p>Completed: ${task.completed}</p>
</body>
</html>