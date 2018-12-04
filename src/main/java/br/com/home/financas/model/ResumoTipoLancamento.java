package br.com.home.financas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.home.financas.model.pk.ResumoTipoLancamentoPK;

@Entity
@Table(name="RESUMOTIPOLANCAMENTO")
public class ResumoTipoLancamento implements Serializable {

	private static final long serialVersionUID = 556883954282552640L;
	
	@EmbeddedId
	private ResumoTipoLancamentoPK id;
	
	@Valid
	@NotNull(message = "A data da receita é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "RECE_DATA")
	private Date dataReceita;

	public ResumoTipoLancamentoPK getId() {
		return id;
	}

	public Date getDataReceita() {
		return dataReceita;
	}

	public void setId(ResumoTipoLancamentoPK id) {
		this.id = id;
	}

	public void setDataReceita(Date dataReceita) {
		this.dataReceita = dataReceita;
	}

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
		ResumoTipoLancamento other = (ResumoTipoLancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
