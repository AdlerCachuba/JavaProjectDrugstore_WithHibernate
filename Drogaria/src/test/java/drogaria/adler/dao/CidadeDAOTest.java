package drogaria.adler.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import drogaria.adler.domain.Cidade;
import drogaria.adler.domain.Estado;

public class CidadeDAOTest {
	@Ignore
	@Test
	public void salvar() {
	EstadoDAO estadoDAO = new EstadoDAO();
	Estado estado = estadoDAO.buscar(1L);
	
	Cidade cidade = new Cidade();
	cidade.setNome("Ourinhos");
	cidade.setEstado(estado);

	CidadeDAO cidadeDAO = new CidadeDAO();
	cidadeDAO.salvar(cidade);
	
	}
	
	
	@Test
	@Ignore
	public void listar() {
	
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultadoCidades = cidadeDAO.listar();
		
		for(Cidade cidade : resultadoCidades) {
			System.out.println("-");
			System.out.println("Codigo: "+ cidade.getCodigo());
			System.out.println("Nome da cidade:"+cidade.getNome());
			System.out.println("Nome do estado:"+cidade.getEstado().getNome());
			System.out.println("Codigo do estado:"+cidade.getEstado().getCodigo());
			System.out.println("Sigla do estado:"+cidade.getEstado().getSigla());
			System.out.println("-");
			
		}
	}
	@Test
	public void buscar() {
		
		Long codigo = 2L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
	
		System.out.println("-");
		System.out.println("Codigo: "+ cidade.getCodigo());
		System.out.println("Nome da cidade:"+cidade.getNome());
		System.out.println("Nome do estado:"+cidade.getEstado().getNome());
		System.out.println("Codigo do estado:"+cidade.getEstado().getCodigo());
		System.out.println("Sigla do estado:"+cidade.getEstado().getSigla());
		System.out.println("-");
		
	}
	
	
	
	
}
