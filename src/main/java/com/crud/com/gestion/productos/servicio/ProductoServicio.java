package com.crud.com.gestion.productos.servicio;

import com.crud.com.gestion.productos.modelo.Producto;
import com.crud.com.gestion.productos.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio repository;

    public List<Producto>listarProductos(){
        return repository.findAll();

    }
    public Producto guardarProducto(Producto producto){
      return  repository.save(producto);

    }

    public Producto obtenerProductoPorId(Integer id){
        return repository.findById(id).get();
    }
    public void eliminarProducto(Integer id){
        repository.deleteById(id);
    }



}
