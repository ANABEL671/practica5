package com.emergentes.conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionbd {
    
     static String driver ="com.mysql.jdbc.Driver";
    static String url ="jdbc:mysql://localhost:3306/bd_almacen";
    static String usuario ="root";
    static String password ="";
    
    protected Connection conn = null;
    
    public conexionbd(){
        try {
        Class.forName(driver);
            conn = DriverManager.getConnection (url,usuario,password);
            if (conn !=null){
                System.out.println("conexion ok");
            }
        }catch (ClassNotFoundException e ){
                System.out.println("Falta especificar driver"+e.getMessage());
        }
           catch (SQLException e){
                System.out.println("Error al abrir"+e.getMessage());
}
}
    public Connection conectar()
    {
        return conn;
    }
      public void desconectar (){
          try {
              conn.close();
          }catch (SQLException ex){
              
              System.out.println("Error al cerrar la BD"+ex.getMessage());
          }
      }
    }
