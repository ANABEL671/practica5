package com.emergentes.dao;

import com.emergentes.modelo.producto;
import java.util.List;

public interface prodao {
    public void insert(producto producto) throws Exception;
    public void update(producto producto) throws Exception;
    public void delete(int id) throws Exception;
    public producto getById(int id) throws Exception;
    public List<producto> getAll() throws Exception;
    
}