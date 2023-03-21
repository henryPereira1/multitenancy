package com.baeldung.multitenant.controller;

import com.baeldung.multitenant.form.UserForm;
import com.baeldung.multitenant.model.UsuarioModel;
import com.baeldung.multitenant.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class UserController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuario")
    public ResponseEntity<List<UsuarioModel>> listarTodos() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioModel> salvar(@RequestBody UserForm form) {
        UsuarioModel user = form.converter();
        System.out.println(user.getLogin());
        return ResponseEntity.ok(usuarioRepository.save(user));
    }
}
