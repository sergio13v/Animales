<%-- 
    Document   : form_add
    Created on : 16-nov-2019, 20:39:55
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
        
        
        <form action="animalesServlet">
  
  <p><input type="hidden" name="accion" value="insertar"></p>         
  <p>Nombre animal: <input type="text" name="nombre_animal" size="40"></p>
  <p>Descripción: <input type="text" name="descripcion" min="1900"></p>
  
  <p>ID clasificación: <input type="text" name="id_tipo"></p>


  
  
  
  <p>
    <input type="submit" value="Enviar">
    <input type="reset" value="Borrar">
  </p>
</form>
        
        
        
        
        
    </body>
</html>
