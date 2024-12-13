package com.rodrigo.www.carros.service;

import com.rodrigo.www.carros.model.Carro;

import java.util.List;
import java.util.Optional;

public interface CarroService {

    List<Carro> listarCarros();
    Optional<Carro> buscarPorId(Long id);
    Carro guardar(Carro carro);
    void eliminar(Long id);


    Optional<Carro> buscarPorMarca(String marca);
    Optional<Carro> buscarPorModel(String modelo);
}
