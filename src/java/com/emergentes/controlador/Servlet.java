
package com.emergentes.controlador;
import com.emergentes.conexionbd.conexionbd;
import com.emergentes.dao.productoDAO;
import com.emergentes.dao.prodao;
import com.emergentes.modelo.producto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miriam
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            prodao dao = new productoDAO();
            // para recibir id
            int id;
            //para gestionar registros
            producto avi = new producto();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"): "view";
            switch(action){
                
                case"add":
                    request.setAttribute("producto", avi);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getById(id);
                    System.out.println(avi);
                    request.setAttribute("producto", avi);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
                case "delete":
                   id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    //request.getRequestDispatcher("ServletInicio").forward(request, response);
                    response.sendRedirect(request.getContextPath()+"/Servlet");
                    break;
                default:
                    List<producto> lista =dao.getAll();
                    request.setAttribute("producto", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                
                    break;
            }
        }catch(Exception ex){
            System.out.println("error" + ex.getMessage());
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        prodao dao = new productoDAO();
        
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        int stock = Integer.parseInt(request.getParameter("stock"));
        
        producto avi = new producto();
        avi.setId(id);
        avi.setDescripcion(descripcion);
        avi.setStock(stock);
        
        if(id == 0){
            //nuevo registro
            try{
             dao.insert(avi);
             response.sendRedirect("Servlet");
             response.sendRedirect(request.getContextPath()+"/Servlet");
            } catch(Exception ex){
                System.out.println("error"+ ex.getMessage());
            }
        }
        else{
            //actualizacion de un registro
            try{
             dao.insert(avi);
             response.sendRedirect("Servlet");
             //response.sendRedirect(request.getContextPath()+"/Servlet");
            } catch(Exception ex){
                System.out.println("error"+ ex.getMessage());
            }
        
        }
        
    }

}
