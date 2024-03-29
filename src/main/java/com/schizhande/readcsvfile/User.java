package com.schizhande.readcsvfile;

import com.opencsv.bean.CsvBindByName;

public class User {

    @CsvBindByName
    private long id;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private String email;

    @CsvBindByName(column = "country")
    private String country;

    @CsvBindByName
    private int age;

    public User() {
    }

    public User(long id, String name, String email, String country, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
