package com.rodrigo.www.concesionaria.repository;

import com.rodrigo.www.concesionaria.entity.Concesionaria;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConcesionariaRepository extends JpaRepository<Concesionaria, Long>{


    Optional<Concesionaria> findConcesionariasByName(@NotNull String name);
}
