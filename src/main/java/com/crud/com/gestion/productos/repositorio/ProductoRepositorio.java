package com.crud.com.gestion.productos.repositorio;

import com.crud.com.gestion.productos.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository <Producto, Integer>{

}
