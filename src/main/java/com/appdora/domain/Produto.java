package com.appdora.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Produto.
 */
@Entity
@Table(name = "produto")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "preco", precision=10, scale=2)
    private BigDecimal preco;

    @ManyToOne
    private Categoria categoria;

    @OneToMany(mappedBy = "produto")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ItensCheckout> itensCheckouts = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Produto nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Produto quantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Produto preco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Produto categoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<ItensCheckout> getItensCheckouts() {
        return itensCheckouts;
    }

    public Produto itensCheckouts(Set<ItensCheckout> itensCheckouts) {
        this.itensCheckouts = itensCheckouts;
        return this;
    }

    public Produto addItensCheckout(ItensCheckout itensCheckout) {
        this.itensCheckouts.add(itensCheckout);
        itensCheckout.setProduto(this);
        return this;
    }

    public Produto removeItensCheckout(ItensCheckout itensCheckout) {
        this.itensCheckouts.remove(itensCheckout);
        itensCheckout.setProduto(null);
        return this;
    }

    public void setItensCheckouts(Set<ItensCheckout> itensCheckouts) {
        this.itensCheckouts = itensCheckouts;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Produto produto = (Produto) o;
        if (produto.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), produto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Produto{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", quantidade=" + getQuantidade() +
            ", preco=" + getPreco() +
            "}";
    }
}
