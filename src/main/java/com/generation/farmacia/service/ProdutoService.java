package com.generation.farmacia.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.farmacia.model.Produto;
import com.generation.farmacia.repository.ProdutoRepository;

@Service
public class ProdutoService {

	   @Autowired
	    private ProdutoRepository produtoRepository;

	    public List<Produto> buscarPrecoMaximo(BigDecimal precoMaximo) {
	        return produtoRepository.findAll().stream()
	            .filter(produto -> produto.getPreco().compareTo(precoMaximo) <= 0)
	            .toList();
	    }
	
}