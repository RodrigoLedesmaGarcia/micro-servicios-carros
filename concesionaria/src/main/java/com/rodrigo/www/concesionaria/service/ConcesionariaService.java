package com.rodrigo.www.concesionaria.service;

import com.rodrigo.www.concesionaria.entity.Concesionaria;

import java.util.List;
import java.util.Optional;

public interface ConcesionariaService {

    List<Concesionaria> listarTodo();
    Optional<Concesionaria> BuscarPorId(Long id);
    Concesionaria guardar(Concesionaria concesionaria);
    void eliminar(Long id);

    Optional<Concesionaria> findConcesionariasByName(String name);
}
