<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Receiver main page</title>
    <style type="text/css">
        TABLE {
            border-collapse: collapse;
        }

        TD, TH {
            padding: 3px;
            text-align: center;
            border: 1px solid black;
        }
    </style>
</head>
<body>

<form method="get" style="margin-top: 10px">
    <input type="submit" value="Получить сообщения" name="send"><br>

    <h2>Список сообщений</h2>
    <table>
        <tr>
            <th>Число</th>
            <th>Дата</th>
            <th>Текст</th>
        </tr>
        <c:forEach var="message" items="${requestScope.messages}">
            <tr>
                <td>${message.number}</td>
                <td>${message.dateStr}</td>
                <td>${message.text}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>