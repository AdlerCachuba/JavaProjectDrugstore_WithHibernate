package drogaria.adler.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Cidade extends GenericDomain{
	@Column(length = 50, nullable = false)
	private String nome;
	
	//para colocar o estado aqui dentro, é a chave estrangeira.
	// e muitas cidades pertecem a um estado. [ 1-infinito cidade - estado que é apenas 1 ] 
	// e eu preciso avisar que ele é NN ( NOT NULL ) 
	// o JoinColumn serve para personalizar as chaves estrangeiras, e ele tem o nullable
	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
}
