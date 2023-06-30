

public class Aluno extends SQLClass {

    @Key
    int id;

    String nome;
    String email;
    String senha;
    String telefone;
    String sobrenome;

    Aluno() {
        this.setTableName("alunos");
    }

}
