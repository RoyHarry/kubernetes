package org.colorado.springcloud.msvc.usuarios.msvc.usuarios.repositories;

import org.colorado.springcloud.msvc.usuarios.msvc.usuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
