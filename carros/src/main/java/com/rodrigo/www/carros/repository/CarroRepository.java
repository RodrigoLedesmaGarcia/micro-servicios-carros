package com.rodrigo.www.carros.repository;

import com.rodrigo.www.carros.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    Optional<Carro> findCarroByModelo(String modelo);

    Optional<Carro> findCarroByMarca( String marca);

}
