package br.com.igreja.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igreja.api.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
