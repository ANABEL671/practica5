<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body{
            background-color: navajowhite;
            width: 600px;
            aling-items: center;
            padding-right: 100px;
            padding-left: 350px;
}    
.contenedor{
        float: right;
        background-color:#F4ABF2;
        border:2px solid #FF0000;
        width: 600px;
        text-align: center;
}     
.cabecera{
        background-color:#E5BC7A;
        height:10%;
        text-align: center;
}
.izquierda{
          text-align: center;
        background-color:#BDD2EF;

}
table{
    text-align: center;
}
.pie{
        height:5%;
        background-color:#D3D1C1;
        clear:both;
         width: auto;
         text-align: center;

}
    </style>
    <body  >
            <div id="contenedor">
                
    <!-- Cabecera -->
    <div class ="cabecera">
        <h2>PRODUCTOS DAO</h2>
  
    </div>
        <div class ="izquierda">
        
        <h1>LISTA DE PRODUCTOS</h1>
        <h2><a href="Servlet?action=add" >Nuevo</a></h2>
        <table border="1">
             <tr>
                 <th>ID</th>
                <th>DESCRIPCION</th>
                <th>STOCK</th>
                <th> </th>
                <th> </th>   
            </tr>
            <c:forEach var="item" items="${producto}">
            <tr>
                <td>${item.id}</td>
                <td>${item.descripcion}</td>
                <td>${item.stock}</td>
                <td><a href="Servlet?action=edit&id=${item.id}">EDITAR</a></td>
                <td><a href="Servlet?action=delete&id=${item.id}" onclick="return(cofirm('ESTA SEGURO DE ELIMINAR'))">ELIMINAR</a></td>
            </tr>
            </c:forEach>
        </table>
       
       
        </div>
        
    <!-- Pie de pagina -->
    <div class ="pie">        <p>&copy Emergentes  LUNA</p>
    
   </div>
            </div>
    </body>
</html>

