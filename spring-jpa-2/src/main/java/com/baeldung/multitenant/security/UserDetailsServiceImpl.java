package com.baeldung.multitenant.security;

import com.baeldung.multitenant.model.UsuarioModel;
import com.baeldung.multitenant.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioModel usuario = usuarioRepository.findByLogin(username);
        System.out.println(usuario.getLogin());
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : usuario.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return User.builder()
                .username(usuario.getLogin())
                .password(usuario.getPassword())
                .authorities(authorities)
                .build();
    }
}
