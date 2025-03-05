package aplicacao;

import dominio.Pessoa;
import dominio.PessoaEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class programa {
    public static void main(String[] args) {

        //Esse objeto é para instanciar objetos EntityManager, representa a 'fabrica' de gerenciadores de entidades
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

        //Responsavel por interagir diretamente com o BD, gerencia entidades e suas operações como persistir, buscar, atualizar e deletar
        EntityManager em = emf.createEntityManager();


        PessoaEntity a = new PessoaEntity();
        a.setNome("Ana");
        a.setIdade(25);

        PessoaEntity b = new PessoaEntity();
        b.setNome("Bob");
        b.setIdade(225);

        PessoaEntity c = new PessoaEntity();
        c.setNome("Carlos");
        c.setIdade(25);

        //Começando a transação para o BD
        em.getTransaction().begin();

        //Persistindo as informações no banco de dados utilizando o EntityManager(em) já que essa é a função dele
        em.persist(a);
        em.persist(b);
        em.persist(c);

        //Terminando a transação dos dados e fazendo o commit para o BD (só está confirmando que a transação ja acabou e salvou no BD)
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Pessoa persistida com sucesso!");


    }
}
