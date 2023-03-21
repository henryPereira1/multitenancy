package com.baeldung.multitenant.form;

import com.baeldung.multitenant.model.UsuarioModel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class UserForm {
    private String login;
    private String name;
    private String password;
    private String tenantSchema;

    public UserForm(){}

    public UsuarioModel converter() {
        return new UsuarioModel(login, name, password, tenantSchema);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTenantSchema() {
        return tenantSchema;
    }

    public void setTenantSchema(String tenantSchema) {
        this.tenantSchema = tenantSchema;
    }
}
