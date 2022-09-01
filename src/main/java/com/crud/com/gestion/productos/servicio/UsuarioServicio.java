package com.crud.com.gestion.productos.servicio;


import com.crud.com.gestion.productos.modelo.Usuario;
import com.crud.com.gestion.productos.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario>listarUsuarios(){
        return repository.findAll();
    }
    public Usuario guardarUsuario(Usuario usuario){
        return repository.save(usuario);
    }
    public Usuario obtenerUsuarioPorId(Integer id){
        return repository.findById(id).get();
    }
    public void eliminarUsuario(Integer id){
        repository.deleteById(id);
    }
}
