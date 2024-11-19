package com.projetofinal.gruposeis.model.ficha;


import com.projetofinal.gruposeis.model.individuo.Individuo;
import com.projetofinal.gruposeis.model.produto.Produto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ficha")
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "idIndividuo")
    private Individuo individuo;
}
