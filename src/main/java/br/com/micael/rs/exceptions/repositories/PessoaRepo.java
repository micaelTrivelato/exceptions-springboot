package br.com.micael.rs.exceptions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.micael.rs.exceptions.entities.Pessoa;

public interface PessoaRepo extends JpaRepository<Pessoa, Long>{
    
}
