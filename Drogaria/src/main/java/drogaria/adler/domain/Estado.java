package drogaria.adler.domain;

import javax.persistence.Entity;
// (@Entity) = vai criar 1 tabela, pq é uma entidade
// e pra isso a gente mapeia lá no hibernate.cfg.xml
@Entity
public class Estado extends GenericDomain {

	// vou ter 3 colunas, uma código, que vem do generic domain
	// outra sigla e outra nome.
	private String sigla;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
