package com.crud.com.gestion.productos.controlador;


import com.crud.com.gestion.productos.modelo.Producto;
import com.crud.com.gestion.productos.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class ProductoControlador {

    @Autowired
    private ProductoServicio service;

    @GetMapping("/producto")
    public List<Producto> listarProductos() {
        return service.listarProductos();
    }


    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id) {
        try {
            Producto producto = service.obtenerProductoPorId(id);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);

        } catch (Exception exception) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/producto")
    public Producto guardarProducto(@RequestBody Producto producto) { // @RequestBody esta recibiendo un cuerpo
        return service.guardarProducto(producto);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id) {
        try {
            Producto productoExistente = service.obtenerProductoPorId(id);
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());
            service.guardarProducto(productoExistente);

        } catch (Exception exception) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
        return null;
    }

        @DeleteMapping("/producto/{id}")
        public void eliminarProducto(@PathVariable Integer id){
        service.eliminarProducto(id);
        }

}
