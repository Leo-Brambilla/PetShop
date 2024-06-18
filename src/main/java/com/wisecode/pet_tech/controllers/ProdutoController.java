package com.wisecode.pet_tech.controllers;

import com.wisecode.pet_tech.dto.ProdutoDTO;
import com.wisecode.pet_tech.entities.Produto;
import com.wisecode.pet_tech.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Collection<ProdutoDTO>> findAll() {
        var produtos = produtoService.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable UUID id) {
        var produto = produtoService.findById(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO produtoDTO) {
        var produtoSaved = produtoService.save(produtoDTO);
        return ResponseEntity.ok(produtoSaved);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProdutoDTO> update(@RequestBody ProdutoDTO produtoDTO, @PathVariable UUID id) {
        produtoDTO = produtoService.update(id, produtoDTO);
        return ResponseEntity.ok(produtoDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
