package org.colorado.springcloud.msvc.usuarios.msvc.usuarios.controllers;


import org.apache.coyote.Response;
import org.colorado.springcloud.msvc.usuarios.msvc.usuarios.models.entity.Usuario;
import org.colorado.springcloud.msvc.usuarios.msvc.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/findall")
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent())
            return ResponseEntity.ok(usuario.get());
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteUser (@RequestParam Long id){
        Optional<Usuario> usuario = usuarioService.findById(id);
        if(usuario.isPresent()){
            usuarioService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> saveUser(@Valid @RequestBody Usuario usuario, BindingResult result){
        if(result.hasErrors()){
            return validar(result);
        }
        return ResponseEntity.ok(usuarioService.saveUser(usuario));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody Usuario user, BindingResult result, @PathVariable Long id){

        if(result.hasErrors()){
            return validar(result);
        }

        Optional<Usuario> usuario = usuarioService.findById(id);
        if(usuario.isPresent()){
            Usuario usuarioDB = new Usuario();
            usuarioDB.setNombre(user.getNombre());
            usuarioDB.setEmail(user.getEmail());
            usuarioDB.setPassword(user.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUser(usuarioDB));
        }
        return ResponseEntity.notFound().build();

    }

    private ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<String, String>();
        result.getFieldErrors().forEach(
                error -> {
                    errores.put(error.getField(), "El campo"+ error.getField() + " "+error.getDefaultMessage());
                }
        );
        return ResponseEntity.badRequest().body(errores);
    }


}
