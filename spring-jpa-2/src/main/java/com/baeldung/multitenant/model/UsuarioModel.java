package com.baeldung.multitenant.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="Usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;

    private String name;

    private String password;

    @Column(name = "tenant_schema")
    private String tenantSchema;

    @ElementCollection
    private List<String> roles;

    public UsuarioModel(String login, String password, String name, String tenantSchema) {
        this.login = login;
        this.name = name;
        this.tenantSchema = tenantSchema;
        this.password = password;
    }

    public UsuarioModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTenantSchema() {
        return tenantSchema;
    }

    public void setTenantSchema(String tenantSchema) {
        this.tenantSchema = tenantSchema;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
