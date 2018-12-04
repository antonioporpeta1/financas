package br.com.home.financas.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.home.financas.model.TipoLancamento;

@Embeddable
public class ResumoTipoLancamentoPK implements Serializable {

	private static final long serialVersionUID = 7135203033604859453L;

	@Valid
	@NotNull(message = "Informe o id")
	@Column(name = "RESU_ID")
	private int id;
	
	@Valid
	@NotNull(message = "Informe o Tipo Lançamento")
    @ManyToOne
	@JoinColumn(name = "TIPO_ID")
	private TipoLancamento tipoLancameto;

	public int getId() {
		return id;
	}

	public TipoLancamento getTipoLancameto() {
		return tipoLancameto;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTipoLancameto(TipoLancamento tipoLancameto) {
		this.tipoLancameto = tipoLancameto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((tipoLancameto == null) ? 0 : tipoLancameto.hashCode());
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
		ResumoTipoLancamentoPK other = (ResumoTipoLancamentoPK) obj;
		if (id != other.id)
			return false;
		if (tipoLancameto == null) {
			if (other.tipoLancameto != null)
				return false;
		} else if (!tipoLancameto.equals(other.tipoLancameto))
			return false;
		return true;
	}
}
