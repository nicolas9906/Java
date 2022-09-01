package com.crud.com.gestion.productos.controlador;


import com.crud.com.gestion.productos.modelo.Usuario;
import com.crud.com.gestion.productos.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio service;


    @GetMapping("/usuario")
    public List<Usuario> listarUsuarios(){
        return service.listarUsuarios();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario>obtenerUsuarioPorId(@PathVariable Integer id){
        try{
            Usuario usuario= service.obtenerUsuarioPorId(id);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }catch (Exception exception) {
        return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/usuario")
    public Usuario guardarUsuario (@RequestBody Usuario usuario){
        return service.guardarUsuario(usuario);
    }
    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> actualizarUsiario(@RequestBody Usuario usuario,
                                                     @PathVariable Integer id) {
        try {
            Usuario usuarioExistente = service.obtenerUsuarioPorId(id);
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setDocumento(usuario.getDocumento());
            service.guardarUsuario(usuarioExistente);

        } catch (Exception exception) {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
        return null;
    }
    @DeleteMapping("/usuario/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        service.eliminarUsuario(id);
    }
}
