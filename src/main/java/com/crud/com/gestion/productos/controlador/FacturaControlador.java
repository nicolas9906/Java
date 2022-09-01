package com.crud.com.gestion.productos.controlador;


import com.crud.com.gestion.productos.modelo.Factura;
import com.crud.com.gestion.productos.servicio.FacturaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/factura")
public class FacturaControlador {
    private final FacturaServicio service;

    public FacturaControlador(FacturaServicio facturaServicio) {
        service = facturaServicio;
    }

    @GetMapping()
    public List<Factura>listaFactura(){
        return service.listarFactura();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Integer id){
        try{
            Optional<Factura> optionalFactura = service.obtenerFacturaPorId(id);
            Factura factura = optionalFactura.get();
            return new ResponseEntity<Factura>(factura, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<Factura>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping()
    public Factura guardarFactura(@RequestBody Factura factura){
        return service.guardarFactura(factura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizarFactura(@RequestBody Factura factura,
                                                     @PathVariable Integer id) {
        try {
            Optional<Factura> optionalFacturaExistente = service.obtenerFacturaPorId(id);
            Factura facturaExistente = optionalFacturaExistente.get();
            facturaExistente.setTotal(factura.getTotal());
            facturaExistente.setProductos(factura.getProductos());
            facturaExistente.setUsuario(factura.getUsuario());
            service.guardarFactura(facturaExistente);

        } catch (Exception exception) {
            return new ResponseEntity<Factura>(HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarFactura(@PathVariable Integer id){
        service.eliminarFactura(id);
    }



}
