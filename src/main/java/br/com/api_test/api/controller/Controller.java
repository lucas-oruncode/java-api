package br.com.api_test.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/register")
    public Pessoa register(@RequestBody Pessoa p) { 
        return action.save(p);
    }

    @GetMapping("/register")
    public List<Pessoa> selectAll() {
        return action.findAll();
    }

    @GetMapping("/register/{id}")
    public Pessoa selectById(@PathVariable int id) {
        return action.findById(id);
    }

    @PutMapping("/register")
    public Pessoa update(@RequestBody Pessoa p) {
        return action.save(p);
    }

    @DeleteMapping("register/{id}")
    public void delete(@PathVariable int id) {
        Pessoa p = selectById(id);
        action.delete(p);
    }

    @GetMapping("/register/count")
    public long contador(){
        return action.count();
    }

    @GetMapping("/register/order_name")
    public List<Pessoa> orderByName(){
        return action.findByOrderByNome();
    }

    @GetMapping("/register/filter_name")
    public List<Pessoa> filterByName(){
        return action.findByNomeOrderByIdadeDesc("Lucas");
    }

    @GetMapping("/register/filter_term")
    public List<Pessoa> filterByTerm(){
        return action.findByNomeContaining("u");
    }

    @GetMapping("/register/start_with")
    public List<Pessoa> startWith() {
        return action.findByNomeStartsWith("L");
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

}
