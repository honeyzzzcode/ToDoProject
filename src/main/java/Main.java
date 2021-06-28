import java.util.ArrayList;

public class Main {


   public static RecordController recordController = new RecordController();

        public static void main(String[] args) {
            System.out.println("Hello ! Welcome to Notes!");

            boolean running = true;
            while (running) {
                String cmd = InputUtils.askString("\n--------------------------------------------\n" +
                        "\n Possible commands are:\n1.Create Note \n2.List of Notes\n3.Exit program\n4.Delete Note\n5.Find Note" +
                        "\nEnter command: \n" +
                        "\n--------------------------------------------");
                switch (cmd) {
                    case "2":
                        listRecords();
                        break;
                    case "1":
                        createRecord();
                        break;
                    case "3":
                        running = false;
                        break;
                    case "4":
                        deleteRecord();
                        break;
                    case "5":
                        findRecord();
                        break;


                    default:
                        System.out.println("Unknown command");
                }
            }
            System.out.println("Bye Bye");
        }
    private static void createRecord() {

        while (true) {
            try {
              Record record =new Record();
                record.askData();
                System.out.println(recordController.createRecord(record)); ;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Mistake");

            }
        }
    }
    private static void findRecord() {
        Record record = RecordController.findRecord(1);
       System.out.println(record.text + " found!");
    }

    private static void deleteRecord() {
        int id = InputUtils.askInt("ID");


    }

    private static void listRecords() {
       ArrayList<Record> records = RecordController.getAllRecords();
        System.out.println("All Notes");
        for (Record currentRecord: records){
            System.out.println(currentRecord.id + " - " + currentRecord.text);
        };
    }
}
