package drogaria.adler.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


// Notação 01:
// O (@MappedSuperclass) é uma notação pra dizer que essa classe não corresponde a uma tabela, 
// mas vai ser usada por outro para gerar tabela, muito usado em heranças no hibernate
@SuppressWarnings("serial")
@MappedSuperclass
public class GenericDomain implements Serializable {
	// o @Id diz que é uma chave primária. 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// Notação 02
	// O (@GeneratedValue(strategy = GenerationType.AUTO)) faz com que gere uma chave automatica\/
	//todas as chaves primárias vão ser geridas pelo bancoO
	private Long codigo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

}
