<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<%
    String bathpath = request.getScheme() + "://" + request.getServerName();
    if (request.getServerPort() != 80) {
        bathpath += ":" + request.getServerPort();
    }
    bathpath += request.getContextPath();
    pageContext.setAttribute("bathpath", bathpath);
%>
</body>
</html>