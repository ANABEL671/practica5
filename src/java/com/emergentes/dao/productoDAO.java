
package com.emergentes.dao;

import com.emergentes.modelo.producto;
import com.emergentes.conexionbd.conexionbd;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class productoDAO extends conexionbd implements prodao {

    @Override
    public void insert(producto producto) throws Exception {
       try{
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("INSERT into productos (descripcion, stock) values (?,?)");
        ps.setString(1, producto.getDescripcion());
        ps.setInt(2, producto.getStock());
        ps.executeUpdate();
       }catch(Exception e){
            throw e;
    }finally{
          this.desconectar();
       }
    }

    @Override
    public void update(producto producto) throws Exception {
    try{
        this.conectar();
        String sql = "UPDATE  productos set descripcion=?, stock=? where id=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, producto.getDescripcion());
        ps.setInt(2, producto.getStock());
        ps.setInt(3, producto.getId());
        ps.executeUpdate();
       }catch(Exception e){
            throw e;
    }finally{
          this.desconectar();
       }
    }

    @Override
    public void delete(int id) throws Exception {
         try{
        this.conectar();
        String sql ="DELETE FROM  productos WHERE id=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
       }catch(Exception e){
            throw e;
    }finally{
          this.desconectar();
       }
    }

    @Override
    public producto getById(int id) throws Exception {
        producto avi = new producto();
         try{
        this.conectar();
        String sql = "SELECT * FROM  productos WHERE id=? ";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();/* executeQuery devuelve un result set*/
        if(rs.next()){
            avi.setId(rs.getInt("id"));
            avi.setDescripcion(rs.getString("descripcion"));
            avi.setStock(rs.getInt("stock"));
        }
       }catch(Exception e){
            throw e;
    }finally{
          this.desconectar();
       }
        return avi;
    }

    @Override
    public List<producto> getAll() throws Exception {
        List<producto> lista = null;
         try{
        this.conectar();
        String sql = "SELECT * FROM  productos ";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<producto>();
        while(rs.next()){
            producto avi = new producto();
            avi.setId(rs.getInt("id"));
            avi.setDescripcion(rs.getString("descripcion"));
            avi.setStock(rs.getInt("stock"));
            lista.add(avi);
        }
        /*rs.close();
        ps.close();*/
       }catch(Exception e){
            throw e;
    }finally{
          this.desconectar();
       }
        return lista;
    }
    
}
