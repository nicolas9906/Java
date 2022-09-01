package com.crud.com.gestion.productos.repositorio;

import com.crud.com.gestion.productos.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("repositorioUsuario")
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
