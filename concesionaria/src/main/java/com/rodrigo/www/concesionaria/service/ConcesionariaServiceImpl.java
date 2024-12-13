package com.rodrigo.www.concesionaria.service;

import com.rodrigo.www.concesionaria.entity.Concesionaria;
import com.rodrigo.www.concesionaria.repository.ConcesionariaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcesionariaServiceImpl implements ConcesionariaService{

    private final ConcesionariaRepository repository;
    public ConcesionariaServiceImpl(ConcesionariaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Concesionaria> listarTodo() {
        return (List<Concesionaria>) repository.findAll();
    }

    @Override
    public Optional<Concesionaria> BuscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Concesionaria guardar(Concesionaria concesionaria) {
        return repository.save(concesionaria);
    }

    @Override
    public void eliminar(Long id) {
         repository.deleteById(id);
    }

    @Override
    public Optional<Concesionaria> findConcesionariasByName(String name) {
        return repository.findConcesionariasByName(name);
    }
}
