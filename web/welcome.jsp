<%-- 
    Document   : welcome
    Created on : 23/02/2017, 08:17:32 PM
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
         <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>        
        <link href="<%=request.getContextPath()%> /css/starter-template.css" rel="stylesheet"/>
        <link href="css/navbar-fixed-top.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <title>Mi aplicacion sise</title>
       
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navegador.jspf" %>

        <div class="container">
            <div class="starter-template">
                <h1>Bienvenidos alumnos de LPAI</h1>
                <p class="lead">Bienvenidos a la implementación</p>
            </div>
        </div>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
