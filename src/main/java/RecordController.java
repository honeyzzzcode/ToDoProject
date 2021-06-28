import java.sql.SQLException;
import java.util.ArrayList;

public class RecordController {

     public  static RecordRepository recordRepository = new RecordRepository();

    public String createRecord(Record record) {
        try {
           recordRepository.create(record);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "error";
        }
        return "Record created successfully";
    }



    public static Record findRecord(Integer id){
        Record record = null;

        try {
            record = recordRepository.getRecord(id);
        }catch (SQLException e){
            System.out.println(e);
        }

        return record;
    }
    public static ArrayList<Record> getAllRecords() {
        ArrayList<Record> records = new ArrayList<Record>();

        try {
            records = RecordRepository.getAll();

        }catch (SQLException e){
            System.out.println(e);
        }

        return records;
    }
}
