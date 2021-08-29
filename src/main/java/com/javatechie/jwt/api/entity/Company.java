package com.javatechie.jwt.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String localizacao;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String logotipo;
}
