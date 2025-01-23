package br.com.api_test.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api_test.api.models.Person;
import br.com.api_test.api.repository.Repo;
import br.com.api_test.api.services.Services;

@RestController
public class Controller {
    
    @Autowired
    private Repo action;

    @Autowired
    private Services service;


    @PostMapping("/api")
    public ResponseEntity<?> register(@RequestBody Person p) { 
        return service.register(p);
    }

    @GetMapping("/api")
    public ResponseEntity<?> selectAll() {
        return service.selectAll();
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<?> selectById(@PathVariable int id) {
        return service.selectById(id);
    }

    @PutMapping("/api")
    public ResponseEntity<?> update(@RequestBody Person p) {
        return service.update(p);
    }

    @DeleteMapping("api/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return service.delete(id);
    }

    @GetMapping("/api/count")
    public long contador(){
        return action.count();
    }

    @GetMapping("/api/order_name")
    public List<Person> orderByName(){
        return action.findByOrderByName();
    }

    @GetMapping("/api/filter_name")
    public List<Person> filterByName(){
        return action.findByNameOrderByAgeDesc("Lucas");
    }

    @GetMapping("/api/filter_term")
    public List<Person> filterByTerm(){
        return action.findByNameContaining("u");
    }

    @GetMapping("/api/start_with")
    public List<Person> startWith() {
        return action.findByNameStartsWith("L");
    }

    @GetMapping("/api/sum_ages")
    public int sumAges(){
        return action.sumAges();
    }

    @GetMapping("/api/query_bigger_age")
    public List<Person> ageEqualOrBigger() {
        return action.ageEqualOrBigger(28);
    }

    @GetMapping("")
    public String mensagem() {
        return "Hello Word";
    }

    @GetMapping("/welcome/{nome}")
    public String welcome(@PathVariable String nome) {
        return "Bem vindo, " + nome;
    }
     
    @PostMapping("/person")
    public Person pessoa(@RequestBody Person p) {
        return p;
    }

    @GetMapping("/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
