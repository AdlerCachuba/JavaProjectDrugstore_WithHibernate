package drogaria.main.util;

import org.hibernate.Session;
import org.junit.Test;

import drogaria.adler.util.HibernateUtil;

public class HibernateUtilTest {

	@Test
	public void conectar() {
		
		//vo capturar uma fabrica de sessão, pego uma variavel pra guardar isso
		
		//                        pego a fabrica de sessão / ligo ela
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		//encerro a ligação
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
		
	}
}
