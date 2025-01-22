package br.com.api_test.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api_test.api.models.Pessoa;

@Repository
public interface Repo extends CrudRepository<Pessoa, Integer> {
    
    List<Pessoa> findAll();
    
    Pessoa findById(int id);

    List<Pessoa> findByOrderByNome();

    List<Pessoa> findByNomeOrderByIdadeDesc(String nome);

    List<Pessoa> findByNomeContaining(String termo);

    List<Pessoa> findByNomeStartsWith(String termo);

    @Query(value = "SELECT SUM(idade) FROM pessoas", nativeQuery = true)
    int sumAges();

    @Query(value = "SELECT * FROM pessoas WHERE idade >= :idade", nativeQuery = true)
    List<Pessoa> ageEqualOrBigger(int idade);

}
