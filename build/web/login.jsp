<%-- 
    Document   : login
    Created on : 23/02/2017, 07:50:37 PM
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="<%=request.getContextPath()%>"<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/signin.css" rel="stylesheet" type="text/css"/>
        <title>Aplicacion de Registro de Personal</title>

    </head>
    <body>
        <div class="container">
            <form action="LoginServlet" method="post" class="form-horizontal form-signin" >
                <div class="form-group" >
                    <label for="InputUser">Usuario</label>         
                    <input type="text" id="InputUser" name="InputUser" placeholder="Usuario" required class="form-control" />
                </div>

                <div class="form-group">
                    <label for="InputPassword">Password</label>
                    <input class="form-control" type="password" id="InputPassword" name="InputPassword" placeholder="Password" required/>
                </div>
                <div class="form-group"> 
                <button type="submit" class="btn btn-success">Iniciar Sesión</button>
                <c:if test="${requestScope.error != null}">
                    <c:out value="Error al iniciar sesion" />
                </c:if>
                </div>
            </form>

        </div>
    </body>
</html>
