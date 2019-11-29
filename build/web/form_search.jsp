<%-- 
    Document   : form_search
    Created on : 18-nov-2019, 22:19:38
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
  
  <p><input type="hidden" name="accion" value="buscar"></p>     
  <p>Introduzca el ID del animal: <input type="text" name="id_animal" size="40"></p>          
             
  
  <p>
    <input type="submit" value="Enviar">
    <input type="reset" value="Borrar">
  </p>
</form>
        
        
        
    </body>
</html>
