package br.com.api_test.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api_test.api.models.Person;

@Repository
public interface Repo extends CrudRepository<Person, Integer> {
    
    List<Person> findAll();
    
    Person findById(int id);

    List<Person> findByOrderByName();

    List<Person> findByNameOrderByAgeDesc(String name);

    List<Person> findByNameContaining(String term);

    List<Person> findByNameStartsWith(String term);

    int countById(int id);

    @Query(value = "SELECT SUM(age) FROM person", nativeQuery = true)
    int sumAges();

    @Query(value = "SELECT * FROM person WHERE idade >= :age", nativeQuery = true)
    List<Person> ageEqualOrBigger(int age);

}
