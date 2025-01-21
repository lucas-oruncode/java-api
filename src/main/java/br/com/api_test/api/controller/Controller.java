package br.com.api_test.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api_test.api.models.Pessoa;
import br.com.api_test.api.repository.Repo;

@RestController
public class Controller {
    
    @Autowired
    private Repo action;
    
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
