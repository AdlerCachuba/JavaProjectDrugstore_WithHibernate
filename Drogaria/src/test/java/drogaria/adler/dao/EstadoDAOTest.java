package drogaria.adler.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;

import drogaria.adler.domain.Estado;
import drogaria.adler.util.HibernateUtil;


// o @Ignore faz com que ele ele seja skiped
public class EstadoDAOTest {
	@Test		
	@Ignore
	public void salvar() {
		
		Estado estado = new Estado();
		
		// vou inventar os dados pra testar
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		
		//listar volta um resultado, ent eu crio uma lista
		List<Estado> resultado = estadoDAO.listar();
		
		System.out.println("Total de resultados encontrados: "+ resultado.size());
		for(Estado estado : resultado) {
			System.out.println(estado.getNome() + estado.getSigla());
		}
		
	}
	
	@Test
	@Ignore
	public void buscar() {
	
		// crio uma chave primária pra pesquisar
		Long codigo = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if (estado == null) {
			System.out.println("Nenhum registro encontrado - ERRO NA BUSCA");
		}else {
		System.out.println(estado.getNome() + estado.getSigla());
		}
		}
	
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		
		Estado estado = estadoDAO.buscar(codigo);
		
		if (estado==null) {
			System.out.println("Nenhum registro encontrado para deletar!");
		}
		else {
		estadoDAO.excluir(estado);
		System.out.println("O registro a ser removido:" + estado.getNome() + " - "+ estado.getSigla());
		System.out.println("... sistema trabalhando");
		System.out.println("Registro removido com sucesso");

		}
		
	}

	
	// eu vou salvar alguma coisa \/ um tipo Entidade,
	@Test
	public void editar() {
		Long codigo = 1L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado==null) {
			System.out.println("Registro não encontrado para edição");
		}
		else {
			System.out.println("Registo encontrado: "+ estado.getNome() + estado.getSigla());
			estado.setSigla("JR");
			estadoDAO.editar(estado);
			System.out.println("Sistema trabalhando para editar ..");
			
			
			System.out.println("Registro editado");
			System.out.println("Registro POS edição: "+estado.getNome() + estado.getSigla());
		}

		

	}
}
