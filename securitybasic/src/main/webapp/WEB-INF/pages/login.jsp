<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login</title>
</head>
<body>

<c:if test="${param.error != null}" >
Failed to login. ${error}
    <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
        Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
    </c:if>
</c:if>

<c:if test="${param.logout != null}" >
    You have been logged out.
</c:if>

<c:url value="/login" var="loginUrl" />
<form action="${loginUrl}" method="post" >   <%-- action mora da je login-processing-url --%>
    <label for="username">Username</label>
    <input type="text" id="username" name="username"/>

    <label for="password">Password</label>
    <input type="password" id="password" name="password"/>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <input type="submit" id="submit" name="submit" value="Login"/>
</form>
</body>
</html>
