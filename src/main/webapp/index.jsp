<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>


<%--
  Created by IntelliJ IDEA.
  User: reevamerchant
  Date: 10/31/16
  Time: 4:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Friends and Their Desserts</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<h1>Create Your Friend Entry</h1>
<form method="post" action="/sleepover/friend">
    <table>
        <tr><td>Name:</td> <td><input type="text" name="name" value="<c:out value="${createFriend.name}"/>"></td></tr>
        <tr><td>Allergies:</td> <td><input type="text" name="allergies" value="<c:out value="${createFriend.allergies}"/>"></td></tr>
        <tr><td>Sleepover:</td> <td><input type="text" name="sleepover" value="<c:out value="${createFriend.sleepover}"/>"></td></tr>
        <tr><td>Birthday:</td> <td><input type="text" name="birthday" value="<c:out value="${createFriend.birthday}"/>"></td></tr>
    </table>
    <input type="submit" value="Save">
</form>

Your session new friend looks like this:
<table border="1">
    <tr><th>Edit</th><th>Name</th><th>Allergies</th><th>Sleepover</th><th>Remove</th></tr>
    <c:forEach items="${friendList}" var="newFriend">
        <tr><td><a href="/service/friendsdesserts/{id}<c:out value="${newFriend.id}"/>">EDIT</a> </td><td><c:out value="${newFriend.name}"/></td><td><c:out value="${newFriend.allergies}"/></td><td><c:out value="${newFriend.sleepover}"/></td><td><a href="/service/friendsdesserts/delete/{id}<c:out value="${newFriend.id}"/>">Remove This Item</a> </td></tr>
    </c:forEach>
</table>

</body>
</html>

</body>
</html>
