
public class Professor extends SQLClass {
    
    @Key
    int id;

    String nome;
    String sobrenome;
    String titulacao;
    String especialidade;

    Professor() {
        this.setTableName("professores");
    }

}
