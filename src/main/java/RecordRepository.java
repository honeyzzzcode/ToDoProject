import DataBase.DBHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RecordRepository {
    private static DBHandler dbHandler = new DBHandler();


    public void create(Record record) throws SQLException {

        String query = "INSERT INTO records( text,status) VALUES(?,?)";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);


        preparedStatement.setString(1, record.text);
        preparedStatement.setString(2, record.status);
        preparedStatement.execute();
        preparedStatement.close();

    }

    public static ArrayList<Record> getAll() throws SQLException {
        Statement statement = dbHandler.getConnection().createStatement();

        String query = "SELECT * FROM records";
        ResultSet results = statement.executeQuery(query);
        ArrayList<Record> records = new ArrayList<Record>();


        while (results.next()) {
            int id = results.getInt("id");
            String text = results.getString("text");
            String status = results.getString("status");
            records.add((Record) new Record(id, text, status));
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
                results.getString("text"),
                results.getString("status")
        );

        statement.close();

        return record;
    }


    public static void delete(int id) throws SQLException {
        String query = "DELETE FROM " + "records" + " WHERE " + "id" + "=?";

        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);
        int update = preparedStatement.executeUpdate();
        if (update == 1) {
            System.out.println("Successfully deleted one row");
        } else if (update == 0) {
            System.out.println("Nothing was deleted. Probably ID is wrong!");
        }
        preparedStatement.execute();
        preparedStatement.close();
    }

    public static void markAsComplete(int id) throws SQLException {

        String query = "UPDATE records SET status = ? WHERE id =?;";

        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1, "complete");
        preparedStatement.setInt(2,id);
        int update = preparedStatement.executeUpdate();
        if (update == 1) {
            System.out.println("Successfully completed ");
        } else if (update == 0) {
            System.out.println("Nothing was changed. Probably ID is wrong!");
        }
        preparedStatement.execute();
        preparedStatement.close();
    }


}
