package org.colorado.springcloud.msvc.cursos.msvccursos.repositories;


import org.colorado.springcloud.msvc.cursos.msvccursos.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
}
