<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Task</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], select { width: 100%; max-width: 400px; padding: 8px; }
        button { padding: 10px 15px; background: #007bff; color: white; border: none; cursor: pointer; }
        button:hover { background: #0056b3; }
    </style>
</head>
<body>

    <h2>Create a New Task</h2>

    <form action="${pageContext.request.contextPath}/tasks/new" method="post">

        <!-- Title Field -->
        <div class="form-group">
            <label for="title">Task Title:</label>
            <input type="text" id="title" name="title" required />
        </div>

        <!-- Priority Field -->
        <div class="form-group">
            <label for="priority">Priority:</label>
            <select id="priority" name="priority">
                <option value="Low">Low</option>
                <option value="Medium">Medium</option>
                <option value="High">High</option>
            </select>
        </div>

        <!-- Completed Field (Checkbox) -->
        <div class="form-group">
            <label>
                <input type="checkbox" name="completed" value="true" /> Completed
            </label>
        </div>

        <button type="submit">Save Task</button>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/">Back to Home</a>

</body>
</html>