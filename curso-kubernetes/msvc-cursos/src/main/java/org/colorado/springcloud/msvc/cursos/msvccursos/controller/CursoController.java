package org.colorado.springcloud.msvc.cursos.msvccursos.controller;

import org.colorado.springcloud.msvc.cursos.msvccursos.entity.Curso;
import org.colorado.springcloud.msvc.cursos.msvccursos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/findCursos")
    public ResponseEntity<List<Curso>> getAllCursos(){
        return ResponseEntity.ok(cursoService.listar());
    }

    @GetMapping("/findCurso/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id){
        Optional<Curso> curso = cursoService.getCursoById(id);
        if(curso.isPresent()){
            return ResponseEntity.ok(curso.get());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Curso crear(@RequestBody Curso curso){
        return cursoService.guardar(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Curso curso, @PathVariable Long id){

       Optional<Curso> cursodb = cursoService.getCursoById(id);
       if(cursodb.isPresent()){
           return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.guardar(curso));
       }
       return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Curso> curso = cursoService.getCursoById(id);
        if(curso.isPresent()){
            cursoService.eliminar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
