
public class SQLFactory {
    public static void main(String[] args) {

        // OBS: Modifique a url de conexão do banco em "MyDatabase.connection"

        // Criacao dos registros de aluno
        Aluno aluno = new Aluno();
        Aluno aluno2 = new Aluno();

        aluno.email = "teste@email.com";
        aluno.id = 12;
        aluno.nome = "mello";
        aluno.sobrenome = "diniz";
        aluno.telefone = "68193661";
        aluno.senha = "fejawuogfjaeuogjnoeageagea";

        
        aluno2.email = "gmail@email.com";
        aluno2.id = 9;
        aluno2.nome = "geovane";
        aluno2.sobrenome = "fiirst";
        aluno2.telefone = "24680161";
        aluno2.senha = "geoiadjguo9eaghea";

        // Criacao dos registros de professor
        Professor professor = new Professor();
        Professor professor2 = new Professor();

        professor.id = 5;
        professor.especialidade = "Programação";
        professor.nome = "leticia";
        professor.titulacao = "graduada";
        professor.sobrenome = "Pieper";

        professor2.id = 8;
        professor2.especialidade = "Programação";
        professor2.nome = "Adriano";
        professor2.titulacao = "Graduado";
        professor2.sobrenome = "Barreto";

        try {

            // ALUNO
            System.out.println("ALUNO");
            // Insere os registros no SQL
            MyDatabase.insertSQL(aluno);
            MyDatabase.insertSQL(aluno2);

            // Printa todos os dados do banco referente a tabela aluno
            MyDatabase.returnSQL(aluno);
            System.out.println("Dados inseridos");
            System.out.println("**********************************");
        
            // Atualiza os dados de um aluno em especifico
            aluno2.email = "meuemail@gmail.com";
            aluno2.nome = "Geovani";
            MyDatabase.updateSQL(aluno2);

            // Printa os dados novamente
            MyDatabase.returnSQL(aluno2);
            System.out.println("Dados atualizados");
            System.out.println("**********************************");

            // Deleta os dados
            MyDatabase.deleteSQL(aluno);

            // Printa novamente
            MyDatabase.returnSQL(aluno2);
            System.out.println("Dados deletados");
            System.out.println("**********************************");

            // PROFESSOR
            System.out.println("");
            System.out.println("PROFESSOR");

            // Insere os registros no SQL
            MyDatabase.insertSQL(professor);
            MyDatabase.insertSQL(professor2);

            // Printa todos os dados do banco referente a tabela aluno
            MyDatabase.returnSQL(professor);
            System.out.println("Dados inseridos");
            System.out.println("**********************************");
        
            // Atualiza os dados de um aluno em especifico
            professor.titulacao = "Graduada";
            professor.nome = "Leticia";
            MyDatabase.updateSQL(professor);

            // Printa os dados novamente
            MyDatabase.returnSQL(professor);
            System.out.println("Dados atualizados");
            System.out.println("**********************************");

            // Deleta os dados
            MyDatabase.deleteSQL(professor);

            // Printa novamente
            MyDatabase.returnSQL(professor);
            System.out.println("Dados deletados");
            System.out.println("**********************************");

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
