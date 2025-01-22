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

import br.com.api_test.api.models.Pessoa;
import br.com.api_test.api.repository.Repo;

@RestController
public class Controller {
    
    @Autowired
    private Repo action;

    @PostMapping("/api")
    public Pessoa register(@RequestBody Pessoa p) { 
        return action.save(p);
    }

    @GetMapping("/api")
    public List<Pessoa> selectAll() {
        return action.findAll();
    }

    @GetMapping("/api/{id}")
    public Pessoa selectById(@PathVariable int id) {
        return action.findById(id);
    }

    @PutMapping("/api")
    public Pessoa update(@RequestBody Pessoa p) {
        return action.save(p);
    }

    @DeleteMapping("api/{id}")
    public void delete(@PathVariable int id) {
        Pessoa p = selectById(id);
        action.delete(p);
    }

    @GetMapping("/api/count")
    public long contador(){
        return action.count();
    }

    @GetMapping("/api/order_name")
    public List<Pessoa> orderByName(){
        return action.findByOrderByNome();
    }

    @GetMapping("/api/filter_name")
    public List<Pessoa> filterByName(){
        return action.findByNomeOrderByIdadeDesc("Lucas");
    }

    @GetMapping("/api/filter_term")
    public List<Pessoa> filterByTerm(){
        return action.findByNomeContaining("u");
    }

    @GetMapping("/api/start_with")
    public List<Pessoa> startWith() {
        return action.findByNomeStartsWith("L");
    }

    @GetMapping("/api/sum_ages")
    public int sumAges(){
        return action.sumAges();
    }

    @GetMapping("/api/query_bigger_age")
    public List<Pessoa> ageEqualOrBigger() {
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
    public Pessoa pessoa(@RequestBody Pessoa p) {
        return p;
    }

    @GetMapping("/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
