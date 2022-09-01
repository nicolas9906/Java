package com.crud.com.gestion.productos.servicio;


import com.crud.com.gestion.productos.modelo.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaServicio {
    List<Factura> listarFactura();
    Factura guardarFactura(Factura factura);
    Optional<Factura> obtenerFacturaPorId(Integer id);
    void eliminarFactura(Integer id);
}
