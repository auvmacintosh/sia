<%--
  Created by IntelliJ IDEA.
  User: wangbo
  Date: 7/13/18
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
User
<c:out value="${qlyUser.id}"/>,
<c:out value="${qlyUser.name}"/>
</body>
</html>
