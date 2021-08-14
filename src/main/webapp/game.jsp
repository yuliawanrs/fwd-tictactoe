<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${fieldSize} x ${fieldSize}</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
        td {
            height: 20px;
            width: 20px;
            text-align: center;
        }
        div {
            height:100%;
            width:100%
        }
    </style>
</head>
<body>
    <h1>${status}</h1>
    ${field}
    <p><a href="index.jsp">Go to home</a></p>
</body>
</html>
