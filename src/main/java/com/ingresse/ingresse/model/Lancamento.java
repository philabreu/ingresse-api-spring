package com.ingresse.ingresse.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

	private static final long serialVersionUID = -6481537318484943981L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;

	@Getter
	@Setter
	@NotNull
	private String descricao;

	@Column(name = "data_vencimento")
	@Getter
	@Setter
	@NotNull
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dataVencimento;

	@Column(name = "data_pagamento")
	@Getter
	@Setter
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dataPagamento;

	@Getter
	@Setter
	@NotNull
	private BigDecimal valor;

	@Getter
	@Setter
	@Size(max = 100)
	private String observacao;

	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	@Column(name = "tipo_lancamento")
	@NotNull
	private TipoLancamento tipoLancamento;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	@Getter
	@Setter
	@NotNull
	private Category category;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	@Getter
	@Setter
	@NotNull
	private Pessoa pessoa;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
