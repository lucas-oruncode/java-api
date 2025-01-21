package br.com.api_test.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api_test.api.models.Pessoa;

@Repository
public interface Repo extends CrudRepository<Pessoa, Integer> {
        
}
