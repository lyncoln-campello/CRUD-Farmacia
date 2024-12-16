package com.generation.farmacia.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O atributo nome é Obrigatório!")
	@Size(min = 10, max = 100, message = "O atributo nome deve conter no mínimo 10 e no máximo 100 caracteres")
	private String nome;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "O estoque é obrigatório!")
	@Positive(message = "O preço deve ser maior do que zero!")
	private BigDecimal preco;

	@NotBlank(message = "O atributo fabricante é Obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo fabricante deve conter no mínimo 5 e no máximo 100 caracteres")
	private String fabricante;

	@Min(value = 0, message = "O valor minimo para estoque é 0")
	@NotNull(message = "Preço é obrigatório!")
	private int estoque;

	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
