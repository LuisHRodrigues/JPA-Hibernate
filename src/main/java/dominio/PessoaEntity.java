package dominio;

//Importações para o funcionamento do hibernate na classe (são os '@' que estão sendo usados)
import javax.persistence.*;
import java.io.Serializable;

@Entity //Definindo que essa classe vai se tornar uma tabela no banco de dados
@Table(name = "usuario") //Nome da tabela
public class PessoaEntity implements Serializable {

    @Id
    @Column(name="id") //Definindo que o atributo 'id' da classe vai receber o nome 'usuario-id' lá no BD (só esta mundando de nome)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Definindo que esse atributo vai ser a PK da tabela "Usuario" e que vai ser auto-incrementada

    @Column(nullable=false) //Definindo que esse atributo não pode ir para o BD se estiver null
    private String nome;

    @Column(nullable=true) // Definindo que esse atributo pode ir null para o BD
    private int idade;

    //Um construtor vazio
    public PessoaEntity(){

    }
    public PessoaEntity(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    //Metodos Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
