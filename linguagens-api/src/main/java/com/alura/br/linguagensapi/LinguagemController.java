package com.alura.br.linguagensapi;

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
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;

    // CRUD (Create, Read, Update and Delete)
    // O método PUT do CRUD não está atualizando :/ - verificar assim que possível

    @GetMapping("/Linguagens")
    public List<Linguagem> obterLinguagens(){
        List<Linguagem> linguagens = repositorio.findByOrderByRanking();
        return linguagens;
    }

    @PostMapping("/Linguagens") // Requisição POST retornando código "201 Created"
    public ResponseEntity<Linguagem> cadastrarLinguagem(@RequestBody Linguagem linguagem){
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return new ResponseEntity<>(linguagemSalva, HttpStatus.CREATED);
    }

    @GetMapping("/Linguagens/{id}")
    public Linguagem obterLinguagemPorId(@PathVariable String id) {
        return repositorio.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/Linguagens/{id}")
    public Linguagem atualizarLinguagem(@PathVariable String Id, @RequestBody Linguagem linguagem){
           if (!repositorio.existsById(Id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); // verificar pq não retorna Erro 404 no Postman
           }
            linguagem.setId(Id);
            Linguagem linguagemSalva = repositorio.save(linguagem);
            return linguagemSalva;
        }

    @DeleteMapping("/Linguagens/{id}")
    public void excluirLinguagem(@PathVariable String id){
        repositorio.deleteById(id);
    }
        
}


