package br.com.api_test.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api_test.api.models.Mensagem;

@Service
public class Servico {
    
    @Autowired
    private Mensagem mensagem;
    
}
