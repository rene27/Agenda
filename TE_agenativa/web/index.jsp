<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.emergentes.modelo.Contacto"%>
<%
    ArrayList<Contacto> lista = (ArrayList<Contacto>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de contactos</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Telefono</th>
            </tr>
            <c:forEach var="item" items="${lista}">
            <tr>
                <th>${item.id}</th>
                <th>${item.nombre}</th>
                <th>${item.telefono}</th>
                <th>${item.correo}</th>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
