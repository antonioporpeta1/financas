package br.com.home.financas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TIPOLANCAMENTO")
public class TipoLancamento implements Serializable {

	private static final long serialVersionUID = 350306714854742614L;

	@Id
	@Valid
	@NotNull(message = "Informe o id")
	@Column(name = "TIPO_ID")
	private int id;
	
	@Valid
	@NotNull(message = "Informe a descrição")
	@Size(max = 45, message = "A descrição não pode conter mais de 45 caracteres")
	@Column(name = "TIPO_DESCRICAO")
	private String descricao;
	
	@Valid
	@NotNull(message = "Informe se desmembra o ítem")
	@Size(max = 1, message = "A opção desmembra ítem não pode conter mais de 1 caracter")
	@Column(name = "TIPO_DESMEMBRAITEM")
	private String desmembraItem;

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getDesmembraItem() {
		return desmembraItem;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDesmembraItem(String desmembraItem) {
		this.desmembraItem = desmembraItem;
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
		TipoLancamento other = (TipoLancamento) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
