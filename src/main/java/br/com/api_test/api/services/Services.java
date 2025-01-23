package br.com.api_test.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api_test.api.models.Message;
import br.com.api_test.api.models.Person;
import br.com.api_test.api.repository.Repo;

@Service
public class Services {
    
    @Autowired
    private Message message;
    
    @Autowired
    private Repo action;

    public ResponseEntity<?> register(Person p) {
        
        if (p.getName().equals("")) {

            message.setMessage("O nome precisa ser preenchido.");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

        } else if (p.getAge() < 0) {

            message.setMessage("Necessário uma idade valida.");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

        } else {

            return new ResponseEntity<>(action.save(p), HttpStatus.CREATED);

        }
    }

    public ResponseEntity<?> selectAll() {
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> selectById(int id) {
        if (action.countById(id) == 0) {
            message.setMessage("Este ID não existe.");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.findById(id), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> update(Person p) {

        if (action.countById(p.getId()) == 0 ) {
            
            message.setMessage("Cadastro não exite.");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

        } else if (p.getName() == "")  {

            message.setMessage("Nome não informado.");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

        } else if (p.getAge() < 0) {

            message.setMessage("Informe uma idade válida.");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
            
        } else {

            return new ResponseEntity<>(action.save(p), HttpStatus.OK);

        }

    }

    public ResponseEntity<?> delete(int id) {

        if (action.countById(id) == 0){

            message.setMessage("Cadastro não encontrado.");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

        }   else {

            Person p = action.findById(id);
            action.delete(p);

            message.setMessage("Usuario (" + p.getId() + ") " + p.getName() + " removido com sucesso!");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }     

    }

}
