package org.colorado.springcloud.msvc.cursos.msvccursos.services;

import org.colorado.springcloud.msvc.cursos.msvccursos.entity.Curso;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public interface CursoService {

    List<Curso> listar();
    Optional<Curso> getCursoById(Long id);
    Curso guardar(Curso curso);
    void eliminar(Long id);
}
