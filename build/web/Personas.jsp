 <%-- 
    Document   : Personas
    Created on : 02/03/2017, 08:04:10 PM
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
         <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/navbar-fixed-top.css" rel="stylesheet" type="text/css"/>
        <!--Plantillas de bootstrap-->
        <link href="css/starter-template.css" rel="stylesheet" type="text/css"/>
        <link href="css/signin.css" rel="stylesheet" type="text/css"/>
        <title>Mi Aplicación SISE</title>
        <script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>   
    <body>
         <%@include file="WEB-INF/jspf/navegador.jspf" %>
        
        <div class="container">
            <form>
            <div class="table-responsive">
                <div class="starter-template">
                    <table class="table table-condensed table-hover table-striped>"
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombres</th>
                                <th>Apellidos</th>
                                <th>Direcci&oacute;n</th>
                                <th>Acciones</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="lst" items="${personas}">
                                <tr>
                                    <td><c:out value="${lst.id}"/></td>
                                    <td><c:out value="${lst.nombres}"/></td>
                                    <td><c:out value="${lst.apellidos}"/></td>
                                    <td><c:out value="${lst.direccion}"/></td>
                                    <td><a href="EditarPersonaServlet?idpersona=${lst.id}" class="btn btn-default" aria-label="Left-Align">
                                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                        <a href="EliminarPersonaServlet?idpersona=${lst.id}" class="btn btn-default" aria-label="Left-Align">
                                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            
                        </tbody>
                    </table>
                </div>
            </div>
                </form>
        </div>
             
        <script src="js/bootstrap.min.js" type="text/javascript"></script>  
    </body>
</html>
