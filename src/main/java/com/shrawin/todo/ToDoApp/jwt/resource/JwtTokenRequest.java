package com.shrawin.todo.ToDoApp.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

    private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;

    /*
    * {
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU4NzQxNzYzMSwiaWF0IjoxNTg2ODEyODMxfQ.fIswPAKCRafuCQhVi8e_nLDT87-8SRZ9rYTYpX-b3dWlh-tt89ep5zg9KGq67l4J0pGOu2z4b4hqPC3IgpiIOw"
}
    * */

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}