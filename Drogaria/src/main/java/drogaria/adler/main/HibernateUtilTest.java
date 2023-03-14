package drogaria.adler.main;

import org.hibernate.Session;

import drogaria.adler.util.HibernateUtil;

public class HibernateUtilTest {
public static void main(String[] args) {
	
	//vo capturar uma fabrica de sessão, pego uma variavel pra guardar isso
	
	//                        pego a fabrica de sessão / ligo ela
	Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
	
	//encerro a ligação
	sessao.close();
	HibernateUtil.getFabricaDeSessoes().close();
	
}
}
