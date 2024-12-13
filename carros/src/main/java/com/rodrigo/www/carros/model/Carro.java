package com.rodrigo.www.carros.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String marca;

    @NotNull
    private String modelo;

    @NotNull
    @Column(name = "año")
    private String ano;

    @NotNull
    private String color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getMarca() {
        return marca;
    }

    public void setMarca(@NotNull String marca) {
        this.marca = marca;
    }

    public @NotNull String getModelo() {
        return modelo;
    }

    public void setModelo(@NotNull String modelo) {
        this.modelo = modelo;
    }

    public @NotNull String getAno() {
        return ano;
    }

    public void setAno(@NotNull String ano) {
        this.ano = ano;
    }

    public @NotNull String getColor() {
        return color;
    }

    public void setColor(@NotNull String color) {
        this.color = color;
    }
}
