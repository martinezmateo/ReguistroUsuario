package com.example.demo.controller;


import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> listUsuarios(){
        List<Usuario> usuarios = usuariosRepository.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> idUsers(@PathVariable Integer id){
        Optional<Usuario> usuario = usuariosRepository.findById(id);
        if (usuario.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK );
    }


}
