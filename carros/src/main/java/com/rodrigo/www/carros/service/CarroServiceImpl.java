package com.rodrigo.www.carros.service;

import com.rodrigo.www.carros.model.Carro;
import com.rodrigo.www.carros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService{

    @Autowired
    private CarroRepository repository;

    @Override
    public List<Carro> listarCarros() {
        return (List<Carro>)repository.findAll();
    }

    @Override
    public Optional<Carro> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Carro guardar(Carro carro) {
        return repository.save(carro);
    }

    @Override
    public void eliminar(Long id) {
         repository.deleteById(id);

    }

    @Override
    public Optional<Carro> buscarPorMarca(String marca) {
        return repository.findCarroByMarca(marca);
    }

    @Override
    public Optional<Carro> buscarPorModel(String modelo) {
        return repository.findCarroByMarca(modelo);
    }
}
