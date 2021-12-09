package com.telynet.prueba.data.entity;

public class Customer {

    private int code;
    private String name;
    private String phone;
    private String email;
    private boolean visited;

    public Customer() {
    }

    public Customer(int code, String name, String phone, String email, boolean visited) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.visited = visited;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", visited=" + visited +
                '}';
    }


}
