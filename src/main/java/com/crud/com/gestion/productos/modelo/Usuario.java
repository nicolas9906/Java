package com.crud.com.gestion.productos.modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="usuario")
public class Usuario{

    @Id
    @Column(name = "usuarios_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "N_documento")
    private Integer Documento;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private Set<Factura> facturas = new HashSet<>();


    public Usuario() {
    }

    public Usuario(Integer id, String nombre, Integer documento) {
        this.id = id;
        this.nombre = nombre;
        Documento = documento;
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

    public Integer getDocumento() {
        return Documento;
    }

    public void setDocumento(Integer documento) {
        Documento = documento;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
        for(Factura factura : facturas){
            factura.setUsuario(this);
        }
    }

}
