package org.colorado.springcloud.msvc.cursos.msvccursos.entity;

import javax.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
