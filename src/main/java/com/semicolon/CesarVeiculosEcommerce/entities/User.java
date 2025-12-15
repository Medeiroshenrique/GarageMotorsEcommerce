package com.semicolon.CesarVeiculosEcommerce.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)//para que os emails não se repitam
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private String password;

    @OneToMany(mappedBy = "client")//o nome é client pq na outra classe esse foi o nome do role
    //SE NÃO FIZER COM ESSA COERÊNCIA DE NOMES NÃO FUNCIONARÁ.
    private List<Order> orders = new ArrayList<>();


    public User(){}

    public User(Long id, String name, String email, String phoneNumber,
                LocalDate birthDate, String password){

        this.id = id;
        this.name = name;
        this.email= email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
