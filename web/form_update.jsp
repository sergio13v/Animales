<%-- 
    Document   : form_update
    Created on : 18-nov-2019, 20:53:52
    Author     : RENO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
         <form action="animalesServlet" >
  
  <p><input type="hidden" name="accion" value="actualizar"></p>              
  <p>Introduzca el ID del animal: <input type="text" name="id_animal" size="40" value=${id_animal} readonly=readonly></p>          
             
  <p>Nombre animal: <input type="text" name="nombre_animal" size="40" value="${nombre_animal}"></p>
  <p>Descripción: <input type="text" name="descripcion" size="40" value="${descripcion}"></p>
  
  <p>ID clasificación: <input type="text" name="id_tipo" value=${id_tipo}></p>


  
  
  
  <p>
    <input type="submit" value="Enviar">
    <input type="reset" value="Borrar">
  </p>
</form>
        
        
    </body>
</html>
