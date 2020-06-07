<<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <style>
        body{
            background-color: navajowhite;
            width: 600px;
            aling-items: center;
            padding-right: 100px;
            padding-left: 450px;
        }    
        form{
            padding: 50px;
            background-color:lightcyan;
            border:2px solid blue;
            width: 600px;
            text-align: center;
        }  
        h2{
            text-align: center;
            font-family: cursive;
            
        }

    </style>
    </head>
    <body>
        <h2><c:if test="${producto.id ==0}" >NUEVO
            </c:if>
            <c:if test="${producto.id !=0}" >EDITAR
            </c:if>
            PRODUCTOS</h2>
            
            <form action="Servlet" method="post" >
                <input type="hidden" name="id" value="${producto.id}" /> 

                        <label>DESCRIPCION</label>
                        <textarea name="descripcion" rows="4" cols="20" >${producto.descripcion}</textarea> 
                        <br>
                        
                        <label>STOCK</label>
                        <input type="number" name="titulo" value="${producto.stock}" />
                        <br>
                        
                        <input type="submit" value="Enviar" />
                   
                
            </form>
    </body>
</html>