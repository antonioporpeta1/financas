package br.com.home.financas.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ADICIONALTOTAL")
public class AdicionalTotal implements Serializable {

	private static final long serialVersionUID = 3563635739924204944L;

	@Id
	@Valid
	@NotNull(message = "Informe o id")
	@Column(name = "ADIC_ID")
	private int id;

	@Valid
	@Column(name = "ADIC_VALOR")
	private BigDecimal valor;
	
	@Valid
	@Size(max = 45, message = "A observação não pode conter mais de 45 caracteres")
	@Column(name = "ADIC_OBS")
	private String obs;
	
	@Valid
	@NotNull(message = "O Tipo de Lancamento é obrigatório")
	@ManyToOne
	@JoinColumn(name = "TIPO_ID")
	private TipoLancamento tipoLancamento;

	public int getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getObs() {
		return obs;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		AdicionalTotal other = (AdicionalTotal) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
