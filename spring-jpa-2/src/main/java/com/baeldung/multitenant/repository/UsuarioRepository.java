package com.baeldung.multitenant.repository;

import com.baeldung.multitenant.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    public UsuarioModel findByLogin(String login);

}
