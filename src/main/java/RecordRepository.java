import DataBase.DBHandler;
import com.sun.prism.impl.Disposer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public  class RecordRepository {
    private static DBHandler dbHandler = new DBHandler();

    public void create(Record record) throws SQLException {
        String query = "INSERT INTO records(id, text) VALUES(?,?)";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, record.id);
        preparedStatement.setString(2, record.text);
        preparedStatement.execute();
        preparedStatement.close();
    }


    public static ArrayList<Record> getAll() throws SQLException {
        Statement statement = dbHandler.getConnection().createStatement();

        String query = "SELECT * FROM records";
        ResultSet results = statement.executeQuery(query);
        ArrayList<Record> records = new ArrayList<Record>();


        while (results.next()){
            int id = results.getInt("id");
            String text = results.getString("text");
            records.add((Record) new Record(id, text));
        }
        statement.close();
        return records;
    }
    
    public Record getRecord(Integer id) throws SQLException {
        Record record;

        Statement statement = dbHandler.getConnection().createStatement();
        String query = "SELECT * FROM records WHERE id =" + id + " LIMIT 1";

        ResultSet results = statement.executeQuery(query);

        results.next();
       record = new Record(
                results.getInt("id"),
                results.getString("text")

        );

        statement.close();

        return record;
    }
}
