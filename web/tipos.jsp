<%-- 
    Document   : index
    Created on : Nov 19, 2019, 1:02:42 AM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Tipos</title>
    </head>
    <body>  
        <div class="container-fluid bg-primary">
            <div class="row justify-content-center">
                <div clas="col-12 text-center">
                    <h1 class="display-1">INFO BIO</h1>
                    <h1 class="text-center display-4">Tipos</h1>
                </div>
            </div>
            
            <%for ( int i = 0; i < 6; i++){ %> 
                    
                    
        
                          <!-- ${i} se suprime por el id en la base de datos y el resultado sera el nombre -->
                        <option id="opts" value="${i}"> ${resultados}</option>
          
                    <%}%>
            
            <div class="row justify-content-center">
                <c:forEach items="${listaTipos}" var="tipo">
                    <div class="col-3 justify-content-around p-5">
                        <div class="card justify-content-center text-center">
                            <img src="${tipo.imagen}" class="card-img-top mr-3" alt="...">
                            <h5 class="card-title text-center">${tipo.nombre}</h5>
                            <div class="card-body justify-content-center">
                                <div class="text-center">
                                    <div class="card-text scrollbar-ripe-malinka" style="height:150px;
                                         overflow-y: auto">${tipo.descripcion}</div>
                                    <a href="/Animales/?tipo=${tipo.id}" class="btn btn-primary">Explorar grupo</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </c:forEach>
                
                                <p><input type="button" value="Añadir" onclick= "location.href = 'form_add.jsp'">
                        
                <p><input type="button" value="Actualizar" onclick= "location.href = 'form_search.jsp'">

            </div>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>