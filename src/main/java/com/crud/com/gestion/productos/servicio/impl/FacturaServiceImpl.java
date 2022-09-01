package com.crud.com.gestion.productos.servicio.impl;

import com.crud.com.gestion.productos.modelo.Factura;
import com.crud.com.gestion.productos.modelo.Usuario;
import com.crud.com.gestion.productos.repositorio.FacturaRepositorio;
import com.crud.com.gestion.productos.repositorio.UsuarioRepository;
import com.crud.com.gestion.productos.servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaServicio {

    @Autowired
    private FacturaRepositorio repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Factura> listarFactura() {
        return repository.findAll();
    }

    @Override
    public Factura guardarFactura(Factura factura) {
        Optional<Usuario> savedUser = usuarioRepository.findById(factura.getUsuario().getId());
        System.out.println("Wiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        if(savedUser.isPresent()) {
            System.out.println("Exist");
            System.out.println(savedUser.get().getNombre());
            factura.setUsuario(savedUser.get());
        } else System.out.println("No exist");
        return repository.save(factura);
    }

    @Override
    public Optional<Factura> obtenerFacturaPorId(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void eliminarFactura(Integer id) {
        repository.deleteById(id);
    }
}
