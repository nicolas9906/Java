package com.crud.com.gestion.productos.repositorio;

import com.crud.com.gestion.productos.modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacturaRepositorio extends JpaRepository<Factura, Integer> {
    Optional<Factura> findById(Integer id);
}
