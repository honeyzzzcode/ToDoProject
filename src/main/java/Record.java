public class Record {
    public String text;
    public int id;

    public Record(int id,String text ) {
        this.text = text;
        this.id = id;
    }

    private static int counter = 0;
    public Record() {
        counter++;
        id = counter;
    }

    @Override
    public String toString() {

        return String.format("id:%d; Text :%s", id,text);
    }

    public void askData(){

       text = InputUtils.askString("Put text:");

    };
    public boolean contains(String substr) {
        String strID = String.valueOf(id);
        return  strID.contains(substr);
    }
}
