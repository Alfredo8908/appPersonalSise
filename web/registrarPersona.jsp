<%-- 
    Document   : registarPersona
    Created on : 23/02/2017, 09:45:27 PM
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=request.getContextPath()%> /css/starter-template.css" rel="stylesheet"/>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/signin.css" rel="stylesheet" type="text/css"/>
        <link href="css/navbar-fixed-top.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <!--<link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet"> Esto es para cuando el navegador no reconoce boostrap -->
        <title>Mi Aplicación SISE</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navegador.jspf" %>

        <div class="container">          




            <c:if test="${requestScope.msg != null}">
                <div class="alert alert-info" role="alert">
                    <p>${requestScope.msg}</p><!--El requestScope es como el request.getParameter-->
                </div>
            </c:if>

            <form action="RegistrarPersonaServlet" method="post">
                <h2 class="form-signin-heading">Registro de Personal</h2>

                <input type="hidden" name="InputId" value="${requestScope.persona.id}">
                <div class="form-group">
                    <label for="InputNombre">Nombres:</label>
                    <input type="text" class="form-control" value="${requestScope.persona.nombres}" id="InputNombre"  name="InputNombre" placeholder="Nombre Completo" required="">
                </div>

                <div class="form-group">
                    <label form="InputApellido">Apellidos</label>
                    <input type="text" class="form-control" value="${requestScope.persona.apellidos}" id="InputApellido" name="InputApellido" placeholder="Apellido Completo" required="">
                </div>

                <div class="form-group">
                    <label form="InputDireccion">Dirección</label>
                    <input type="text" class="form-control" value="${requestScope.persona.direccion}" id="InputDireccion" name="InputDireccion" placeholder="Direccion Completa" required="">
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary" value="Guardar">Guardar</button>
                    <button type="reset" class="btn btn-default" value="Cancelar">Cancelar</button>
                </div>
            </form>

        </div>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
    <!--<script src="js/ie10-viewport-bug-workaround.js"> Esto es para cuando el navegador no reconoce boostrap  -->
</html>
