package com.crud.com.gestion.productos.modelo;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "productos")
public class Producto {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "producto_id")
    private Integer id;

     private String nombre;
     private float Precio;
    @ManyToMany(mappedBy = "productos",cascade = CascadeType.ALL)
    private List<Factura> facturas  = new ArrayList<>();


    public Producto() {
    }

    public Producto(Integer id, String nombre, float precio) {
        this.id = id;
        this.nombre = nombre;
        Precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        Precio = precio;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id.equals(producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

