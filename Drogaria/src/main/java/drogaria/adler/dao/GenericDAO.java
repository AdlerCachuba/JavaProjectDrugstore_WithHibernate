package drogaria.adler.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import drogaria.adler.domain.Estado;
import drogaria.adler.util.HibernateUtil;

// o " <> " é um nome generico pro meu domain
public class GenericDAO<Entidade> {

	// Aqui, aula 152.
	// captura de classe
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		// no construtor, eu vou chamar o comando
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		// ele pega o tiposuper classe dele, por exemplo, o EstadoDAO possui o
		// GenericDAO<Estado>
		// ele quebra o generic Dao e pega a Class tipo Estado
	}

	// eu vou salvar alguma coisa \/ um tipo Entidade,
	public void salvar(Entidade entidade) {

		// pega a fabrica de sessão, e abre ela.
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		// agora declara o objeto pra controlar transações
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}

	}

	// ele retona uma listagem de entidades
	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {

		// pega a fabrica de sessão, e abre ela.
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		// não preciso de transação e pesquisas, pq as pesquisas só consultam, não
		// editam nada.

		try {
			// pra listar no hibernate
			// existem varios métodos, vamos usar o criteria.
			Criteria consulta = sessao.createCriteria(classe);
			// ele q vai realizar a consulta
			// nos usamos reflection do java, então como é o genérico, a gente vai chamar a
			// variavel classe

			// pra listar a gente usa uma variavel pra guardar o resultado
			List<Entidade> resultado = consulta.list();
			return resultado;
			// essa variavel vai guardar todos os estados que eu tenho.

		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo) {

		// pega a fabrica de sessão, e abre ela.
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		// não preciso de transação e pesquisas, pq as pesquisas só consultam, não
		// editam nada.

		try {
			// pra listar no hibernate
			// existem varios métodos, vamos usar o criteria.
			Criteria consulta = sessao.createCriteria(classe);

			// aqui vamos usar critérios de busca
			consulta.add(Restrictions.idEq(codigo));
			// ele pega o valor que o usuário digitou, e comparara com a chave primária da
			// sua entidade
			// ele sabe a chave primária por causa do @Id

			// pra listar a gente usa uma variavel pra guardar o resultado
			Entidade resultado = (Entidade) consulta.uniqueResult();
			// unique result só retorna um resultado. ele precisa de um casting para o tipo
			// entidade
			return resultado;

		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	// eu vou salvar alguma coisa \/ um tipo Entidade,
	public void excluir(Entidade entidade) {

		// pega a fabrica de sessão, e abre ela.
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		// agora declara o objeto pra controlar transações
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}

	}

	
	// eu vou salvar alguma coisa \/ um tipo Entidade,
	public void editar(Entidade entidade) {

		// pega a fabrica de sessão, e abre ela.
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		// agora declara o objeto pra controlar transações
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
