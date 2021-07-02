import java.sql.SQLException;
import java.util.ArrayList;

public class Main {


   public static RecordController recordController = new RecordController();

        public static void main(String[] args) throws SQLException {
            System.out.println("Hello ! Welcome to Notes!");

            boolean running = true;
            while (running) {
                String cmd = InputUtils.askString("\n--------------------------------------------\n" +
                        "\n Possible commands are:\n1.Create Note \n2.List of Notes\n3.Exit program\n4.Delete Note\n5.Find Note\n6.Mark as complete" +
                        "\nEnter command: \n" +
                        "\n--------------------------------------------");
                switch (cmd) {
                    case "2" -> listRecords();
                    case "1" -> createRecord();
                    case "3" -> running = false;
                    case "4" -> deleteRecord();
                    case "5" -> findRecord();
                    case "6"->markAsComplete();
                    default -> System.out.println("Unknown command");
                }
            }
            System.out.println("Bye Bye");
        }

    private static void markAsComplete() throws SQLException {
        int id= InputUtils.askInt("Please enter an id to mark as complete: ");
        RecordRepository.markAsComplete(id);
    }

    private static void createRecord() {

        while (true) {
            try {
           Record record = new Record();
                record.askData();
                System.out.println(recordController.createRecord(record));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Mistake");

            }
        }
    }
    private static void findRecord() {
        Record record = RecordController.findRecord(InputUtils.askInt("Put id :"));
       System.out.println(record.toString() + " found!");
    }

    private static void deleteRecord() throws SQLException {
        int id= InputUtils.askInt("Please enter an id to remove an item: ");
        RecordRepository.delete(id);
    }

    private static void listRecords() {
       ArrayList<Record> records = RecordController.getAllRecords();
        System.out.println("All Notes");
        for (Record currentRecord: records){
            System.out.println(currentRecord.id + " - " + currentRecord.text+ " - "+ currentRecord.status);
        }
    }
}
