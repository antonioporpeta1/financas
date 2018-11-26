package br.com.home.financas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="DESPESAS")
public class Despesas implements Serializable {

	private static final long serialVersionUID = 3708254241826323525L;

	@Id
	@Valid
	@NotNull(message = "Informe o id")
	@Column(name = "DESP_ID")
	private int id;
	
	@Valid
	@NotNull(message = "A data da despesa é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DESP_DATA")
	private Date dataDespesa;
	
	@Valid
	@Column(name = "DESP_VALOR")
	private BigDecimal valor;
	
	@Valid
	@NotNull(message = "Informe a parcela")
	@Column(name = "DESP_PARCELA")
	private int parcela;
	
	@Valid
	@Size(max = 45, message = "A observação não pode conter mais de 45 caracteres")
	@Column(name = "DESP_OBS")
	private String obs;
	
	@Valid
	@NotNull(message = "Informe a situação")
	@Size(max = 1, message = "A situação não pode conter mais de 1 caracter")
	@Column(name = "DESP_SITUACAO")
	private String situacao;
	
	@Valid
	@NotNull(message = "O Tipo de Lancamento é obrigatório")
	@ManyToOne
	@JoinColumn(name = "TIPO_ID")
	private TipoLancamento tipoLancamento;

	public int getId() {
		return id;
	}

	public Date getDataDespesa() {
		return dataDespesa;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public int getParcela() {
		return parcela;
	}

	public String getObs() {
		return obs;
	}

	public String getSituacao() {
		return situacao;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDataDespesa(Date dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
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
		Despesas other = (Despesas) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
