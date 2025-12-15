package com.semicolon.CesarVeiculosEcommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //COMO CONFIGURAR O TEMPO PARA O PADRÃO HORÁRIO MUNDIAL(utc, depois você traduz pra o formato local que pretender)
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order(){}

    public Order(Long id, Instant moment, OrderStatus status){
        this.id = id;
        this.moment = moment;
        this.status = status;
    }

}
