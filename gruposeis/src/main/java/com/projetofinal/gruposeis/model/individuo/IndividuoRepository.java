package com.projetofinal.gruposeis.model.individuo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IndividuoRepository extends JpaRepository<Individuo,Long> {
    List<Individuo> findByCPF(String CPF);
}
