package io.github.augustorsn.back_end_baba.rest.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.augustorsn.back_end_baba.domain.Produto;
import io.github.augustorsn.back_end_baba.repository.ProdutoJpa;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private ProdutoJpa produtos;

    public ProdutoController(ProdutoJpa produtos) {
        this.produtos = produtos;
    }

    @GetMapping("{id}")
    public Produto getProdutoById(@PathVariable Integer id) {
        Optional<Produto> produto = produtos.findById(id);
        if (produto.isPresent()) {
            return produto.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "produto não encontrado");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto saveProduto(@RequestBody Produto produto) {
        try {
            return produtos.save(produto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "produto não encontrado");
        }
    }
}