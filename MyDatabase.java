import java.sql.*;
import java.lang.reflect.*;

public class MyDatabase {
    
    public static Connection connection() {

        // MODIFIQUE ESTA PARTE PARA NAO GERAR ERROS
        String urlConnection = "jdbc:sqlite:F:\\Desenvolvimento\\leticia\\SQLFactory\\db\\database.db";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(urlConnection);
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void selectSQLData(SQLClass object) throws SQLException, NoSuchFieldException, SecurityException {

        Connection connection = connection();

        Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery(object.selectSQL());

        // Pega os campos
        Field[] fields = object.listFields();

        while(result.next()) {

            for(int c = 0; c < fields.length; c++) {

                String fieldName = format(fields[c].toString());

                if(fieldName == "id" || fieldName == "ID") {
                    System.out.println("nao");
                    int res = result.getInt(fieldName);
                    System.out.println(fieldName + ": " + res);
                } else {
                    String res = result.getString(fieldName);
                    System.out.println(fieldName + ": " + res);
                }

            }

            System.out.println("----------------------------------");

        }
    }

    public static void executeSQLCommand(String sql) throws SQLException {
        Connection connection = connection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        connection.close();
    }

    // CRUD
    public static void insertSQL(SQLClass object) throws SQLException {
        executeSQLCommand(object.insertSQL());
    }

    public static void deleteSQL(SQLClass object) throws SQLException {
        executeSQLCommand(object.deleteSQL());
    }

    public static void updateSQL(SQLClass object) throws SQLException {
        executeSQLCommand(object.updateSQL());
    }

    public static void returnSQL(SQLClass object) throws SQLException, NoSuchFieldException {
        selectSQLData(object);
    }

    private static String format(String string) {

        String[] list = string.trim().split("\\.");

        return list[list.length -1];
    }

}
