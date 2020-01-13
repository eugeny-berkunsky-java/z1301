<%--
  Created by IntelliJ IDEA.
  User: eberk
  Date: 13.01.2020
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <jsp:useBean id="calc" type="logic.FunctionCalculator" scope="request"/>
    <h2>a = ${calc.a}</h2>
    <h2>b = ${calc.b}</h2>
    <h2>h = ${calc.h}</h2>
    <h1>max Y = ${calc.y}</h1>
    <h1>max X = ${calc.x}</h1>
    <form action="qwerty" method="post">
        <input type="text" name="X" value="${calc.x}">
    </form>
</body>
</html>
