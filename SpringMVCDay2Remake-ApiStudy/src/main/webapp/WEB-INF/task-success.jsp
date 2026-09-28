<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Created Successfully</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .success-card { background: #f8f9fa; border: 1px solid #dee2e6; padding: 20px; max-width: 400px; border-radius: 5px; }
        h2 { color: #28a745; margin-top: 0; }
        ul { padding-left: 20px; }
        li { margin-bottom: 8px; }
    </style>
</head>
<body>

    <div class="success-card">
        <h2>🎉 Task Created Successfully!</h2>
        <p>Here are the details of the task you just added:</p>

        <ul>
            <li><strong>Title:</strong> ${task.title}</li>
            <li><strong>Priority:</strong> ${task.priority}</li>
            <li><strong>Completed:</strong> ${task.completed ? 'Yes' : 'No'}</li>
        </ul>
    </div>

    <br>
    <a href="${pageContext.request.contextPath}/tasks/new">➕ Create Another Task</a> |
    <a href="${pageContext.request.contextPath}/">🏠 Back to Home</a>

</body>
</html>