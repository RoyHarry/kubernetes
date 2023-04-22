package org.colorado.springcloud.msvc.usuarios.msvc.usuarios.service;

import org.colorado.springcloud.msvc.usuarios.msvc.usuarios.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> findAll ();
    Optional<Usuario> findById (Long id);
    Usuario saveUser (Usuario user);
    void deleteUser (Long id);

}
