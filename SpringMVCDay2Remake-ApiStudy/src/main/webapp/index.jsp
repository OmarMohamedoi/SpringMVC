<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Session 2 Lab -- Part 1</title></head>
<body>
    <h1>Session 2 Lab -- Part 1 (No Forms)</h1>

    <h3>Task 1 -- read endpoints</h3>
    <ul>
        <li><a href="tasks">tasks</a> -- list all</li>
        <li><a href="tasks/1">tasks/1</a> -- one task by id</li>
        <li><a href="tasks/search?priority=HIGH">/tasks/search?priority=HIGH</a> -- filter</li>
    </ul>


    <h3>Task 4 -- exception handling</h3>
    <ul>
        <li><a href="tasks/999">/tasks/999</a> -- no such id -&gt; TaskNotFoundException -&gt; @ControllerAdvice</li>
    </ul>

    <h3>Task 5 -- Interceptor vs Filter (watch the console)</h3>
    <ul>
        <li><a href="tasks">/tasks</a> -- both Filter and Interceptor fire</li>
        <li><a href="nope">/nope</a> -- only the Filter fires (no handler matched)</li>
    </ul>
</body>
</html>
