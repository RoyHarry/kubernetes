package org.colorado.springcloud.msvc.usuarios.msvc.usuarios.service;

import org.colorado.springcloud.msvc.usuarios.msvc.usuarios.models.entity.Usuario;
import org.colorado.springcloud.msvc.usuarios.msvc.usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public Usuario saveUser(Usuario user) {
        return usuarioRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        usuarioRepository.deleteById(id);
    }
}
